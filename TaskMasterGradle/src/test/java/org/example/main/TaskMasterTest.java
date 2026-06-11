package org.example.main;

import org.example.model.Categoria;
import org.example.model.Estado;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskMasterTest {

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

        Tarea tarea = new Tarea(1, "Estudiar", "JUnit", LocalDate.of(2026, 6, 11),
                LocalDate.of(2026, 6, 18), "", estado, categoria, usuario);

        assertNotNull(tarea);
        assertEquals(null, tarea);
    }

    @Test
    void usuarioInexistente() {
        assertNull(TaskMaster.buscarUsuario(999));
    }

    @Test
    void usuarioConCamposVacios() {

        Usuario usuario = new Usuario(200, "Juan", "juan@gmail.com", "1234");
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