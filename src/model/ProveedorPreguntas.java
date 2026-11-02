package model;

import java.util.List; 
import java.util.ArrayList;

public class ProveedorPreguntas {
    //Atributos
    private List<Pregunta> preguntasList;

    //Constructor
    public ProveedorPreguntas(){
        this.preguntasList = new ArrayList<>();
        cargarPreguntas(); 
    }
    
   private void cargarPreguntas() {
        // 1\. Historia y Geografía
        preguntasList.add(new Pregunta(
            "¿En qué año se declaró la Independencia Argentina?",
            List.of("1. 1810", "2. 1816", "3. 1820", "4. 1853"),
            2,
            "Historia y Geografía"
        ));
        preguntasList.add(new Pregunta(
            "¿Cuál es la capital de Argentina?",
            List.of("1. Córdoba", "2. Buenos Aires", "3. Rosario", "4. Mendoza"),
            2,
            "Historia y Geografía"
        ));

        // 2\. Arte y Literatura
        preguntasList.add(new Pregunta(
            "¿Quién escribió 'Don Quijote de la Mancha'?",
            List.of("1. Gabriel García Márquez", "2. Miguel de Cervantes", "3.Jorge Luis Borges", "4. Julio Cortázar"),
            2,
            "Arte y Literatura"
        ));
        preguntasList.add(new Pregunta(
            "¿En qué famoso museo se exhibe la 'Mona Lisa' (La Gioconda) de Leonardo da Vinci?",
            List.of("1. Museo del Prado", "2. Galería Uffizi", "3. Museo del Louvre", "4. Museo Británico"),
            3,
            "Arte y Literatura"
        ));

        // 3\. Naturaleza y Ciencia
        preguntasList.add(new Pregunta(
            "¿Cuál es el símbolo químico del agua?",
            List.of("1. CO2", "2. H2O", "3. NaCl", "4. O2"),
            2,
            "Naturaleza y Ciencia"
        ));
        preguntasList.add(new Pregunta(
            "¿Cuál de los siguientes animales raros 'suda' leche para alimentar a sus crías?",
            List.of("1. Armadillo", "2. Pangolín", "3. Ornitorrinco", "4. Diablo de Tasmania"),
            3,
            "Naturaleza y Ciencia"
        ));

        // 4\. Deportes y Juegos
        preguntasList.add(new Pregunta(
            "¿Cuál es el club de fútbol más grande de América?",
            List.of("1. RiBer Plate", "2. Peñarol", "3. Flamengo", "4. Boca Juniors"),
            4,
            "Deportes y Juegos"
        ));
        preguntasList.add(new Pregunta(
            "¿Quién recibió el primer galardón del Laurel Olímpico en los Juegos de Río 2016?",
            List.of("1. Kipchoge Keino", "2. Usain Bolt", "3. Michael Phelps", "4.Eliud Kipchoge"),
            1,
            "Deportes y Juegos"
        ));

        // 5\. Entretenimientos y Espectáculos
        preguntasList.add(new Pregunta(
            "¿Qué famoso grupo musical compuso 'De música ligera'?",
            List.of("1. Serú Girán", "2. Soda Stereo", "3. Los Fabulosos Cadillacs", "4. Patricio Rey"),
            2,
            "Entretenimientos y Espectáculos"
        ));
        preguntasList.add(new Pregunta(
            "¿Cuál es la película más taquillera de la historia del cine?",
            List.of("1. Avatar", "2. Avengers: Endgame", "3. Titanic", "4. Star Wars: El despertar de la Fuerza"),
            1,
            "Entretenimientos y Espectáculos"
        ));
    }
   
    

    public Pregunta obtenerPregunta(String categoria){
        for(Pregunta p : preguntasList)
            if(p.obtenerCategoria().equalsIgnoreCase(categoria)){
                return p;
            }
        return null;
    } 
}
