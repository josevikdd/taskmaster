package org.example.utils;

import org.example.model.Categoria;
import org.example.model.Estado;

public class DatosEstaticos {
    static{
        //Creamos los estados básicos del proyecto.
        Estado e1 = new Estado(1, "Pendiente.", "La tarea aún no ha comenzado.");
        Estado e2 = new Estado(2, "En progreso.", "La tarea ha comenzado.");
        Estado e3 = new Estado(3, "Finalizada.", "La tarea ha sido finalizada.");
        Estado e4 = new Estado(4, "Cancelada.", "La tarea ha sido cancelada.");

        //Creamos las categorías básicas del proyecto.
        Categoria c1 = new Categoria(111, "Deberes DAM.", "Categoría para los deberes del curso DAM.");
        Categoria c2 = new Categoria(222, "Tiempo libre.", "Categoría para actividades que no tienen que ver con los estudios de DAM.");
    }
}
