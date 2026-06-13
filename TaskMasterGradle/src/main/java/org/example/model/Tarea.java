package org.example.model;

import java.time.LocalDate;


/**
 * Representa una tarea asignada a un usuario dentro del sistema TaskMaster.
 * Cada tarea posee un estado, una categoría y un conjunto de datos descriptivos.
 *
 * @author José Vicente Sánchez Vargues
 * @version 1.0
 */
public class Tarea implements Mostrable {
    //Atributos de la clase Tarea
    private int idTarea;
    private String titulo;
    private String descripcion;
    private LocalDate fechaComienzo;
    private LocalDate fechaFinal;
    private String observaciones;

    //Atributos de relación
    private Estado estado;
    private Categoria categoria;
    private Usuario usuario;

    /**
     * Constructor de la clase Tarea.
     *
     * @param idTarea identificador único de la tarea
     * @param titulo título de la tarea
     * @param descripcion descripción de la tarea
     * @param fechaComienzo fecha de inicio de la tarea
     * @param fechaFinal fecha de finalización de la tarea
     * @param observaciones observaciones adicionales
     * @param estado estado actual de la tarea
     * @param categoria categoría asociada a la tarea
     * @param usuario usuario al que pertenece la tarea
     */
    public Tarea(int idTarea, String titulo, String descripcion, LocalDate fechaComienzo, LocalDate fechaFinal, String observaciones, Estado estado, Categoria categoria, Usuario usuario) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public int getId(){
        return idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getFechaComienzo() {
        return fechaComienzo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setFechaComienzo(LocalDate fechaComienzo){
        this.fechaComienzo = fechaComienzo;
    }

    public void setFechaFinal(LocalDate fechaFinal){
        this.fechaFinal = fechaFinal;
    }

    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(idTarea + " - " + titulo + " - " + descripcion +  " - " + fechaComienzo +  " - " + fechaFinal + " - " + observaciones + " - " +
                estado.getNombre() + " - " + categoria.getNombre() + " --> Usuario: " + usuario.getId());
    }

}
