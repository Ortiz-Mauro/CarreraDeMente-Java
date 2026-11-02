package model;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Jugador {

   // Atributos
   private int posicionActual;
   private final Set<String> estrellas; //final porque no se va a cambiar la referencia de la colección, pero sí se pueden agregar elementos a la colección.
   private final Scanner scanner = new Scanner(System.in);
   
    // Constructor o
    public Jugador() {
         this.posicionActual = 0; 
         this.estrellas = new HashSet<>(); // Crea la colección vacía internamente de la clase Jugador para que no se pierdan las estrellas que vaya ganando el jugador.
        //this.estrellas = estrellasIniciales;
    }

    // Métodos
    public void avanzarPosicion(int pasos) {
        this.posicionActual = (this.posicionActual + pasos) % 36; // ESTO SOLO FUNCIONA SI HAY 36 CASILLAS EN EL TABLERO. SI HUBIERA MÁS O MENOS, HAY QUE CAMBIAR EL 36 POR EL NÚMERO DE CASILLAS DEL TABLERO.
    }

    public int obtenerPosicionActual() {
        return posicionActual;
    }

    public int responder(List<String> opciones, String consigna) {
        System.out.println("Consigna: " + consigna);
        System.out.println("Escriba una de las opciones:" + opciones); //las opciones deberian estar enumeradas para que el jugador pueda elegir la opción correcta
        int respuesta = 0;
        while (respuesta < 1 || respuesta > opciones.size()) {
            try {
                respuesta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                respuesta = 0;
            }
            if (respuesta < 1 || respuesta > opciones.size()) {
                System.out.println("Opción inválida. Ingresa un número del 1 al " + opciones.size() + ":");
            }
        }
        return respuesta; // presenta la consigna y opciones al jugagor. Devuelve la respuesta del jugador como un entero
    }

    public void agregarEstrella(String categoria) {
        estrellas.add(categoria);
    }

    public boolean tieneTodasLasEstrellas() {
        return estrellas.size() == 5; 
    }

    public String elegirCategoria() {
        System.out.println("Has caído en una casilla Gris. Elige una categoría:");
        System.out.println("1. Historia y Geografía");
        System.out.println("2. Arte y Literatura");
        System.out.println("3. Naturaleza y Ciencia");
        System.out.println("4. Deportes y Juegos");
        System.out.println("5. Entretenimientos y Espectáculos");
        int opcion = 0;
        while (opcion < 1 || opcion > 5) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción inválida. Ingresa un número del 1 al 5:");
            }
        }
        switch (opcion) {
            case 1: return "Historia y Geografía";
            case 2: return "Arte y Literatura";
            case 3: return "Naturaleza y Ciencia";
            case 4: return "Deportes y Juegos";
            case 5: return "Entretenimientos y Espectáculos";
            default: return "";
        }
    }
}
