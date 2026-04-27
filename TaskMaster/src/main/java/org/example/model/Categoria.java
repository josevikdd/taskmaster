package org.example.model;

public class Categoria implements Mostrable {
    //Atributos de la clase Categoria
    private int idCategoria;
    private String nombre;
    private String descripcion;

    //Constructor de la clase Categoria
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return idCategoria;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idCategoria + " -  " + nombre + " - " + descripcion);
    }
}
