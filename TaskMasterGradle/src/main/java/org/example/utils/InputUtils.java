package org.example.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {

    public static LocalDate readLocalDate(Scanner sc, String mensaje) {
        boolean salir = false;
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (salir == false) {
            System.out.print(mensaje);
            String linea = sc.nextLine();

            if (!linea.isBlank()) {
                try {
                    fecha = LocalDate.parse(linea, formatter);
                    salir = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha no válida. Usa el formato dd/MM/yyyy.");
                }
            } else {
                System.out.println("La fecha no puede estar vacía. Inténtalo de nuevo.");
            }
        }

        return fecha;
    }
}
