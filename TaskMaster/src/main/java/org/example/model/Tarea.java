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
    private Estado estado;
    private Categoria categoria;
    private Usuario usuario;

    public Tarea(int idTarea, String titulo, String descripcion, Date fechaComienzo, Date fechaFinal, String observaciones, Estado estado, Categoria categoria, Usuario usuario) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFinal = fechaFinal;
        this.observaciones = observaciones;
        this.estado = estado;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public void editarTarea(){

    }

    public void completarTarea(){

    }

    public int getId(){
        return idTarea;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idTarea + " - " + titulo + " - " + descripcion +  " - " + fechaComienzo +  " - " + fechaFinal + " - " + observaciones
                + estado.getNombre() + " - " + categoria.getNombre());
    }

}
