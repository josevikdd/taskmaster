package org.example.main;

import org.example.model.Categoria;
import org.example.model.Estado;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.main.TaskMaster.*;
import static org.junit.jupiter.api.Assertions.*;


class TaskMasterTest {

    private static final Scanner sc = new Scanner(System.in);

    @Test
    void crearTareaValida() {
        Usuario usuario = new Usuario(200, "Juan", "juan@gmail.com", "1234");
        Categoria categoria = new Categoria(200, "Trabajo", "");
        Estado estado = new Estado(200, "Pendiente", "");

        Tarea tarea = new Tarea(1, "Estudiar", "JUnit", LocalDate.of(2026, 6, 11),
                LocalDate.of(2026, 6, 18), "", estado, categoria, usuario);

        assertNotNull(tarea);
        assertEquals("Estudiar", tarea.getTitulo());
    }

    @Test
    void fechaFinalAnteriorAInicial() {

        Usuario usuario = new Usuario(200, "Juan", "juan@gmail.com", "1234");
        Categoria categoria = new Categoria(200, "Trabajo", "");
        Estado estado = new Estado(200, "Pendiente", "");
        Tarea tarea = null;

        LocalDate comienzo = LocalDate.of(2026, 6, 11);
        LocalDate finalizacion = LocalDate.of(2026, 6, 7);
        //https://www.geeksforgeeks.org/java/localdate-isbefore-method-in-java-with-examples/
        if (comienzo.isBefore(finalizacion) || comienzo.isEqual(finalizacion)) {
            tarea = new Tarea(1, "Estudiar", "JUnit", comienzo,
                    finalizacion, "", estado, categoria, usuario);
        }

        assertNull(tarea);
    }

    @Test
    void usuarioInexistente() {
        assertNull(buscarUsuario(999));
    }

    @Test
    void usuarioConCamposVacios() {

        System.out.println("Ingrese el ID del usuario: ");
        int id = 200;

        Usuario usuario = null;

        if (buscarUsuario(id) == null){
            String nombre = "";

            String email = "";

            String contrasena = "";

            if (campoVacio(nombre) || campoVacio(email) || campoVacio(contrasena)){
                System.out.println("Por favor, rellene los campos obligatorios para dar de alta a un usuario correctamente.");
            } else {
                usuario = new Usuario(id, nombre, email, contrasena);

                System.out.println("Usuario " + usuario.getId() + " - " + usuario.getNombre() + " dado de alta correctamente.");
                System.out.println();
            }
        }
        else {
            System.out.println("Ya existe un usuario con el ID " + id + ". Volviendo al menú principal.");
            System.out.println();
        }
        assertEquals(null, usuario);
    }

    @Test
    void editarTareaInexistente() {
        assertNull(TaskMaster.buscarTarea(999));
    }

    @Test
    void categoriaVacia() {

        Categoria categoria = new Categoria(200, "Trabajo", "");

        boolean existeTarea = false;

        for (Object obj : TaskMaster.getTareas()) {
            Tarea tarea = (Tarea) obj;

            if (tarea.getCategoria().getId() == categoria.getId()) {
                existeTarea = true;
                break;
            }
        }

        assertFalse(existeTarea);
    }
}