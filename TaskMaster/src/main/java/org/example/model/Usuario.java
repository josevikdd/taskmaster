package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Mostrable {
    //Atributos de la clase Usuario
    private int idUsuario;
    private String nombre;
    private String email;
    private String contrasena;

    //Atributos de relación
    private List<Tarea> tareas;

    //Constructor de la clase Usuario
    public Usuario(int idUsuario, String nombre, String email, String contrasena){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;

        tareas = new ArrayList<>();
    }

    public int getId(){
        return idUsuario;
    }

    public String getNombre(){
        return nombre;
    }

    public List<Tarea> getTareas(){
        return tareas;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idUsuario + " - " + nombre + " - " + email + " - " + contrasena);
    }
}
