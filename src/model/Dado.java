package model;

import java.util.Random;

public class Dado {
    
    //Atributo
    private int valor;

    //Constructor
    public Dado() {
        this.valor = 1; // Inicializa el dado en 1
    }

    //Método
    public int lanzarDado() {
        Random rnd = new Random(); //crea un objeto Random
        valor = rnd.nextInt(6) + 1; //genera un número aleatorio entre 1 y 6
        return valor;
    }
}
