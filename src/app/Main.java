package app;

import java.util.Scanner; 
import java.util.List; 
import controller.ControladorJuego; 
import model.Dado; 
import model.Jugador; 
import model.ProveedorPreguntas; 
import model.Tablero;

/*
 * Esta es la clase principal, actua como punto de entrada e instancia
 * toda la estructura del modelo e inicia la partida de Carrera de Mente.
 */

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========================================");
		System.out.println("	INICIANDO JUEGO - CARRERA DE MENTE	");
		System.out.println("========================================");

		//instancio jugadores
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		//coleccion inmutable de jugadores
		List<Jugador> listaJugadores = List.of(jugador1, jugador2);
		
		//instancio los servicios(model)
		Tablero tablero = new Tablero();
		ProveedorPreguntas proveedor = new ProveedorPreguntas();
		Dado dado = new Dado();
		
		//inyecto las dependencias en el controlador del juego
		ControladorJuego controlador = new ControladorJuego(tablero, proveedor, dado, listaJugadores);
		
		// aca deberia empezar el bucle del juego
		System.out.println("Partida inicializada con exito");
		
		//flag para controlar la salida del juego
		boolean usuarioDeseaSalir = false;
		
		while(!controlador.declararGanador() && !usuarioDeseaSalir){	
			
			System.out.println("\n----------------------------------------");
			System.out.println("TURNO DEL JUGADOR ACTUAL"); 
			System.out.print("Presione [ENTER] para lanzar dado o escriba 'S' para salir: ");
			
			String entrada = scanner.nextLine().trim();
			
			//aca el usuario decide
			if (entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("Salir")){
				System.out.println("\nHa decidido abandonar la partida. Gracias por jugar!");
				usuarioDeseaSalir = true;
			}else {
				controlador.ejecutarTurno();
				}
		}
			
		if (controlador.declararGanador()) {
			System.out.println("\n========================================");
			System.out.println(" FELICITACIONES! ");
			System.out.println("========================================");
		}
	
	scanner.close();
	
	}
}
