package org.example.utils;

import org.example.main.TaskMaster;
import org.example.model.Categoria;
import org.example.model.Estado;
import org.example.model.Tarea;
import org.example.model.Usuario;

import java.util.Date;

public class DatosEstaticos {
    static{
        //Creamos los estados básicos del proyecto.
        Estado e1 = new Estado(1, "Pendiente.", "La tarea aún no ha comenzado.");
        Estado e2 = new Estado(2, "En progreso.", "La tarea ha comenzado.");
        Estado e3 = new Estado(3, "Finalizada.", "La tarea ha sido finalizada.");
        Estado e4 = new Estado(4, "Cancelada.", "La tarea ha sido cancelada.");
        TaskMaster.getEstados().add(e1);
        TaskMaster.getEstados().add(e2);
        TaskMaster.getEstados().add(e3);
        TaskMaster.getEstados().add(e4);

        //Creamos las categorías básicas del proyecto.
        Categoria c1 = new Categoria(1, "Deberes DAM.", "Categoría para los deberes del curso DAM.");
        Categoria c2 = new Categoria(2, "Tiempo libre.", "Categoría para actividades que no tienen que ver con los estudios de DAM.");
        TaskMaster.getCategorias().add(c1);
        TaskMaster.getCategorias().add(c2);

        //Creamos un usuario para ayudarnos con las pruebas del programa.
        Usuario u1 = new Usuario(1, "José Vicente Sánchez Vargues", "josevi@mail.com", "contraseñasegura");
        TaskMaster.getUsuarios().add(u1);

        //Creamos una tarea para ayudarnos con las pruebas del programa.
        Tarea t1 = new Tarea(1, "Q13 - Proyecto Intermodular", "Esta actividad.", new Date("20/04/2026"), new Date("01/05/2026"), "",
                TaskMaster.buscarEstado(2), TaskMaster.buscarCategoria(1), u1);
        TaskMaster.getTareas().add(t1);
    }
}
