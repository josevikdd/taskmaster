package org.example.model;

import java.util.ArrayList;

public class Usuario implements Mostrable {
    //Atributos de la clase Usuario
    private int idUsuario;
    private String nombre;
    private String email;
    private String contrasena;

    //Atributos de relación
    private ArrayList<Tarea> tareas;

    //Constructor de la clase Usuario
    public Usuario(int idUsuario, String nombre, String email, String contrasena){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;

        tareas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idUsuario + " -  " + nombre + " - " + email + " - " + contrasena);
    }
}
