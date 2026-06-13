package org.example.model;

/**
 * Representa una categoría a la que pueden pertenecer las tareas.
 *
 * @author José Vicente Sánchez Vargues
 * @version 1.0
 */
public class Categoria implements Mostrable {

    private int idCategoria;
    private String nombre;
    private String descripcion;

    /**
     * Constructor de la clase Categoria.
     *
     * @param idCategoria identificador único de la categoría
     * @param nombre nombre de la categoría
     * @param descripcion descripción de la categoría
     */
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre de la categoría.
     *
     * @return nombre de la categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el identificador de la categoría.
     *
     * @return identificador de la categoría
     */
    public int getId() {
        return idCategoria;
    }

    /**
     * Muestra los datos de la categoría por consola.
     */
    @Override
    public void mostrarDatos() {
        System.out.println(idCategoria + " - " + nombre + " - " + descripcion);
    }
}
