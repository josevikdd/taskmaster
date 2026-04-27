package org.example.model;

import java.util.ArrayList;
import java.util.Date;

public class Tarea implements Mostrable {
    //Atributos de la clase Tarea
    private int idTarea;
    private String titulo;
    private String descripcion;
    private Date fechaComienzo;
    private Date fechaFinal;
    private String observaciones;

    //Atributos de relación
    private int idEstado;
    private int idCategoria;
    private ArrayList<Usuario> usuarios;

    public Tarea(int idTarea, String titulo, String descripcion, Date fechaComienzo, Date fechaFinal, int idEstado, int idCategoria) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFinal = fechaFinal;
        this.idEstado = idEstado;
        this.idCategoria = idCategoria;
        usuarios = new ArrayList<>();
    }

    public void editarTarea(){

    }

    public void completarTarea(){

    }

    @Override
    public void mostrarDatos() {
        System.out.println(idTarea + " - " + titulo + " - " + descripcion +  " - " + fechaComienzo +  " - " + fechaFinal + " - "
                + idEstado + " - " + idCategoria);
    }

}
