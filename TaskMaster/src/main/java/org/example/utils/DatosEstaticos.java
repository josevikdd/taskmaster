package org.example.utils;

import org.example.main.TaskMaster;
import org.example.model.Categoria;
import org.example.model.Estado;

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
    }
}
