package com.universidadcauca.movil.viewseleccionables.models;

/**
 * Created by DarioFernando on 11/03/2015.
 */
public class Game {

    String titulo, genero, edad;

    public Game(String edad, String genero, String titulo) {
        this.edad = edad;
        this.genero = genero;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
