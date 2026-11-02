package model;

public class Casilla {

    //Atributos
    private String categoria;
    private boolean esEstrella;

    //Constructor
    public Casilla(String categoria, boolean esEstrella){
        this.categoria = categoria;
        this.esEstrella = esEstrella;
    }

    //Metodos
    public String obtenerCategoria(){
        return categoria;
    }

    public boolean esEstrella (){
        return esEstrella;
    }
}
