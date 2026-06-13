package org.example.model;

/**
 * Representa un estado que puede tener una tarea dentro del sistema.
 *
 * @author José Vicente Sánchez Vargues
 * @version 1.0
 */
public class Estado implements Mostrable {

    //Atributos de la clase Estado
    private int idEstado;
    private String nombre;
    private String descripcion;

    /**
     * Constructor de la clase Estado.
     *
     * @param idEstado identificador único del estado
     * @param nombre nombre del estado
     * @param descripcion descripción del estado
     */
    public Estado(int idEstado, String nombre, String descripcion) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el identificador del estado.
     *
     * @return identificador del estado
     */
    public int getId() {
        return idEstado;
    }

    /**
     * Devuelve el nombre del estado.
     *
     * @return nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Muestra los datos del estado por consola.
     */
    @Override
    public void mostrarDatos() {
        System.out.println(idEstado + " - " + nombre + " - " + descripcion);
    }
}