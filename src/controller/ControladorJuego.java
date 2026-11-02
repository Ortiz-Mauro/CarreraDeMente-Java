package controller;

import model.Jugador; 
import model.Tablero; 
import model.Dado; 
import model.ProveedorPreguntas; 
import model.Pregunta;

import java.util.List;

import model.Casilla;

public class ControladorJuego {
    // Atributos de asociación (el controlador conoce a las entidades) 
    private Tablero tablero; 
    private ProveedorPreguntas proveedorPreguntas;
    private Dado dado; 
    private List<Jugador> jugadores;
    private int jugadorActualIndex;

    // Constructor 
    public ControladorJuego(Tablero tablero, ProveedorPreguntas proveedor, Dado dado, List<Jugador> jugadores) { 
        this.tablero = tablero; 
        this.proveedorPreguntas = proveedor; 
        this.dado = dado; 
        this.jugadores = jugadores;
        this.jugadorActualIndex = 0;
    }

    // deberia tener una lista de jugadores donde podria ser que cada jugador se identifique con un indice
    // por ejemplo el jugador 1 sea el indice 0 y el 2 el indice 1 y cuando cambio de turno cambio de jugador cambiando el indice
    
    
    // Método principal que ejecuta un turno completo (Secuencias 1, 2 y 3) 
    public void ejecutarTurno() { 
    // Secuencia 1
    Jugador jugadorActual = obtenerJugadorActual();
    int pasos = dado.lanzarDado(); 
    jugadorActual.avanzarPosicion(pasos); 
    int nuevaPosicion = jugadorActual.obtenerPosicionActual(); 
    Casilla casillaActual = tablero.obtenerCasillaEn(nuevaPosicion); 
    if (casillaActual == null) { 
        return; 
    } 
    String categoria = casillaActual.obtenerCategoria(); 

    //Logica casilla gris
    if (categoria.equalsIgnoreCase("Gris")) {
        categoria = jugadorActual.elegirCategoria(); 
    }
    
    // Secuencia 2 
    Pregunta pregunta = proveedorPreguntas.obtenerPregunta(categoria); 
    if (pregunta == null) { 
        System.out.println("No hay preguntas disponibles para la categoría: " + categoria); 
        return; 
    } 
    List<String> opciones = pregunta.obtenerOpciones();
    String consigna = pregunta.obtenerConsigna();
    int respuestaUsuario = jugadorActual.responder(opciones, consigna); 
    boolean acierto = pregunta.esCorrecta(respuestaUsuario); 
    // Secuencia 3
    if (acierto) { 
        if (casillaActual.esEstrella()) { 
        jugadorActual.agregarEstrella(categoria); 
        } 
            if (jugadorActual.tieneTodasLasEstrellas()) { 
            declararGanador(); 
            } else { 
            notificarAcierto(); 
            } 
    } else { 
    siguienteTurno(); 
    } 
}

    public Jugador obtenerJugadorActual() {
        if (jugadores == null || jugadores.isEmpty()) {
            return null;
        }
        return jugadores.get(jugadorActualIndex);
    }

    public Jugador obtenerJugador(){
        return obtenerJugadorActual();
    }

    public void notificarAcierto() { 
        System.out.println("¡Respuesta correcta! El jugador puede continuar su turno."); 
    }
    public void siguienteTurno() { 
        if(jugadores != null && !jugadores.isEmpty()){
            jugadorActualIndex = (jugadorActualIndex + 1) % jugadores.size();
        }
        System.out.println("Respuesta incorrecta. ceda el turno al siguiente jugador."); 
    }
    public boolean declararGanador() {  
        Jugador jugadorActual = obtenerJugadorActual();
        if (jugadorActual != null && jugadorActual.tieneTodasLasEstrellas()) { 
            System.out.println("El jugador" + jugadorActual + "completó las 5, GANASTE!!!."); 
            return true;
        }
        return false;
    }
}
