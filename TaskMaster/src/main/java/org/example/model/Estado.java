package org.example.model;

public class Estado implements Mostrable{
    //Atributos de la clase Estado
    private int idEstado;
    private String nombre;
    private String descripcion;

    //Constructor de la clase Estado
    public Estado(int idEstado, String nombre, String descripcion) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idEstado + " - " + nombre + " - " + descripcion);
    }
}
