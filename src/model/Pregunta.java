package model;

import java.util.List;

public class Pregunta {
    
    //Atributos
    private String consigna;
    private List<String> opciones;
    private int respuestaCorrecta;
    private String categoria;
    
    //Constructor
    public Pregunta(String consigna, List<String> opciones, int respuestaCorrecta, String categoria) {
        this.consigna = consigna;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.categoria = categoria;
    }

    //Métodos
    public String obtenerConsigna() {
        return consigna; // Devuelve la consigna de la pregunta
    }

    public String obtenerCategoria() {
        return categoria; // Devuelve la categoria de la pregunta
    }

    public List<String> obtenerOpciones() {
        return opciones; // Devuelve la lista de opciones de respuesta
    }

    public boolean esCorrecta(int respuesta) {
        if (respuesta == respuestaCorrecta) { // Compara la respuesta proporcionada con la respuesta correcta
            return true;
        } else {
            return false;
        }
    }
}
