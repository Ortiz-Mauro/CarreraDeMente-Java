package model;

import java.util.List;
import java.util.ArrayList;

public class Tablero {
    private List<Casilla> casillas;

    public Tablero() {
        this.casillas = new ArrayList<>();
        
       // Reemplazamos los colores por los tipos de pregunta, manteniendo "Gris" al final[cite: 3].
        String[] categorias = {
            "Historia y Geografía", 
            "Arte y Literatura", 
            "Naturaleza y Ciencia", 
            "Deportes y Juegos", 
            "Entretenimientos y Espectáculos", 
            "Gris"
        };
        
        // Ciclo para instanciar las 36 casillas
        for (int i = 0; i < 36; i++) {
            
            String colorActual = categorias[i % 6]; 
            
            // Lógica de la estrella: 
            // Se la damos solo en la primera vuelta de casillas (i < 6)
            // y bloqueamos explícitamente que se le asigne al color Gris.
            boolean tieneEstrella = (i < 6) && (!colorActual.equals("Gris"));
            
            // --- Fabricamos el objeto Casilla real y lo guardamos en la memoria del tablero --- TIENE QUE ESTAR EL CONSTRUCTOR DE CASILLA QUE RECIBA EL COLOR Y SI TIENE ESTRELLA O NO.
            Casilla nuevaCasilla = new Casilla(colorActual, tieneEstrella);
            this.casillas.add(nuevaCasilla);
            }
    }

    public Casilla obtenerCasillaEn(int nuevaPos) {
        if (nuevaPos >= 0 && nuevaPos < casillas.size()) {
            return casillas.get(nuevaPos);
        } else {
            return null;    // ----- Significa "no encontré ningún objeto válido en esta dirección".
        }
    }
}
    