package org.example.main;
import org.example.model.Categoria;
import org.example.model.Estado;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.example.utils.DatosEstaticos;

import java.util.*;

public class TaskMaster {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Categoria> categorias = new ArrayList<>();
    private static final List<Estado> estados = new ArrayList<>();
    private static final List<Tarea> tareas = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();

    //Cargamos los datos estáticos para Categoria y Estado.
    private static final DatosEstaticos de = new DatosEstaticos();

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
        System.out.println("Ingrese el ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el email del usuario: ");
        String email = sc.nextLine();
        System.out.println("Ingrese el contraseña del usuario: ");
        String contrasena = sc.nextLine();

        Usuario usuario = new Usuario(id, nombre, email, contrasena);
        usuarios.add(usuario);

        System.out.println("Usuario " + usuario.getId() + " - " + usuario.getNombre() + " dado de alta correctamente.");
    }

    public static void mostrarUsuarios(){
        System.out.println("===LISTA DE USUARIOS===");
        for (Usuario usuario : usuarios){
            usuario.mostrarDatos();
        }
    }

    public static void crearTarea(){}

    public static void editarTarea(){}

    public static void eliminarTarea(){}

    public static void listarTareas(){}

    public static void completarTarea(){}

    public static void listarTareasCategoria(){}

    public static void listarTareasUsuario(){}
}

