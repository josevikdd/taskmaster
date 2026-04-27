package org.example.main;
import java.util.*;

public class TaskMaster {

    private static final Scanner sc = new Scanner(System.in);


    static void main(String[] args) {
        int opcion;

        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> altaUsuario();
                case 2 -> mostrarUsuarios();
                case 3 -> crearTarea();
                case 4 -> editarTarea();
                case 5 -> eliminarTarea();
                case 6 -> listarTareas();
                case 7 -> completarTarea();
                case 8 -> listarTareasCategoria();
                case 9 -> listarTareasUsuario();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    public static void menu(){
        System.out.println("===MENÚ PRINCIPAL===");
        System.out.println("1.- Alta de usuario.");
        System.out.println("2.- Mostrar usuarios.");
        System.out.println("3.- Crear tarea.");
        System.out.println("4.- Editar tarea.");
        System.out.println("5.- Eliminar tarea.");
        System.out.println("6.- Listar tareas.");
        System.out.println("7.- Completar tarea.");
        System.out.println("8.- Listar tareas por categoría.");
        System.out.println("9.- Listar tareas por usuario.");
        System.out.println("0.- Salir.");
    }

    public static void altaUsuario(){

    }

    public static void mostrarUsuarios(){}

    public static void crearTarea(){}

    public static void editarTarea(){}

    public static void eliminarTarea(){}

    public static void listarTareas(){}

    public static void completarTarea(){}

    public static void listarTareasCategoria(){}

    public static void listarTareasUsuario(){}
}

