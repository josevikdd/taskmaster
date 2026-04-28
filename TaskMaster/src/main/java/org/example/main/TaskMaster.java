package org.example.main;
import org.example.model.Categoria;
import org.example.model.Estado;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.example.utils.DatosEstaticos;
import org.example.utils.InputUtils;

import java.time.LocalDate;
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

        if (buscarUsuario(id) == null){
            System.out.println("Ingrese el nombre del usuario: ");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el email del usuario: ");
            String email = sc.nextLine();

            System.out.println("Ingrese el contraseña del usuario: ");
            String contrasena = sc.nextLine();

            Usuario usuario = new Usuario(id, nombre, email, contrasena);
            usuarios.add(usuario);

            System.out.println("Usuario " + usuario.getId() + " - " + usuario.getNombre() + " dado de alta correctamente.");
            System.out.println();
        }
        else {
            System.out.println("Ya existe un usuario con el ID " + id + ". Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static void mostrarUsuarios(){
        if (!usuarios.isEmpty()){
            System.out.println("===LISTA DE USUARIOS===");
            for (Usuario usuario : usuarios){
                usuario.mostrarDatos();
            }
            System.out.println();
        }
        else {
            System.out.println("La lista de usuarios está vacía. Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static void crearTarea(){
        if (!usuarios.isEmpty()){
            mostrarUsuarios();
            System.out.println("Ingrese el ID del usuario al que va a asignar la tarea: ");
            int idUsuario = sc.nextInt();
            if (buscarUsuario(idUsuario) != null){
                Usuario usuario = buscarUsuario(idUsuario);

                System.out.println("Ingrese el ID del tarea: ");
                int id = sc.nextInt();
                sc.nextLine();
                if(buscarTarea(id) == null){
                    System.out.println("Ingrese el nombre del tarea: ");
                    String titulo = sc.nextLine();

                    System.out.println("Ingrese una descripción para la tarea: ");
                    String descripcion = sc.nextLine();

                    LocalDate fechaComienzo = InputUtils.readLocalDate(sc, "Ingrese la fecha de comienzo de la tarea (dd/mm/aaaa): ");

                    LocalDate fechaFinal = InputUtils.readLocalDate(sc, "Ingrese la fecha de finalización de la tarea (dd/mm/aaaa): ");

                    System.out.println("Añada observaciones a la tarea: ");
                    String observaciones = sc.nextLine();

                    System.out.println("Ingrese el estado actual de la tarea (1 - 4):");
                    for (Estado estado : estados){
                        estado.mostrarDatos();
                    }
                    int idEstado = sc.nextInt();
                    if (buscarEstado(idEstado) != null){
                        Estado estado = buscarEstado(idEstado);

                        System.out.println("Ingrese la categoría de la tarea (1 - 2): ");
                        for (Categoria categoria : categorias){
                            categoria.mostrarDatos();
                        }
                        int idCategoria = sc.nextInt();
                        if (buscarCategoria(idCategoria) != null){
                            Categoria categoria = buscarCategoria(idCategoria);

                            Tarea tarea = new Tarea(id, titulo, descripcion, fechaComienzo, fechaFinal, observaciones, estado, categoria, usuario);
                            tareas.add(tarea);
                            usuario.getTareas().add(tarea);

                            System.out.println("Tarea " + tarea.getId() + " - " + tarea.getTitulo() + " correctamente creada.");
                        }
                        else {
                            System.out.println("ID de la categoria no válido. Volviendo al menú principal.");
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("ID del estado no válido. Volviendo al menú principal.");
                        System.out.println();
                    }
                }
                else {
                    System.out.println("Ya existe una tarea con el ID " + id + ". Volviendo al menú principal.");
                    System.out.println();
                }
            }
            else {
                System.out.println("ID no válido. Volviendo al menú principal. ");
                System.out.println();
            }
        }
        else {
            System.out.println("La lista de usuarios está vacía. Cree un usuario al que asignar una tarea antes de crear esta.");
            System.out.println();
        }
    }

    public static void editarTarea(){
        if (!tareas.isEmpty()){
            listarTareas();
            System.out.println("Ingrese el ID de la tarea que quiere modificar: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (buscarTarea(id) != null){
                Tarea tarea = buscarTarea(id);

                System.out.println("¿Desea modificar el usuario de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    mostrarUsuarios();
                    System.out.println("Ingrese el ID del nuevo usuario de la tarea " + id + ".");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    if (buscarUsuario(idUsuario) != null){
                        tarea.getUsuario().getTareas().remove(tarea);
                        Usuario usuario = buscarUsuario(idUsuario);
                        tarea.setUsuario(usuario);
                        usuario.getTareas().add(tarea);
                    }
                    else {
                        System.out.println("ID de usuario no válido. No se ha guardado el cambio.");
                    }
                }

                System.out.println("¿Desea modificar el título de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    System.out.println("Ingrese el nuevo título de la tarea " + id + ".");
                    tarea.setTitulo(sc.nextLine());
                }

                System.out.println("¿Desea modificar la descripción de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    System.out.println("Ingrese la nueva descripción de la tarea " + id + ".");
                    tarea.setDescripcion(sc.nextLine());
                }

                System.out.println("¿Desea modificar la fecha de inicio de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    tarea.setFechaComienzo(InputUtils.readLocalDate(sc, "Ingrese la nueva fecha de inicio de la tarea " + id + " (dd/mm/aaaa): "));
                    System.out.println();
                }

                System.out.println("¿Desea modificar la fecha final de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    tarea.setFechaFinal(InputUtils.readLocalDate(sc, "Ingrese la nueva fecha de finalización de la tarea " + id + " (dd/mm/aaaa): "));
                    System.out.println();
                }

                System.out.println("¿Desea modificar las observaciones de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    System.out.println("Ingrese las nuevas observaciones de la tarea " + id + ".");
                    tarea.setObservaciones(sc.nextLine());
                }

                System.out.println("¿Desea modificar el estado de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    for (Estado estado : estados){
                        estado.mostrarDatos();
                    }
                    System.out.println("Ingrese el nuevo estado de la tarea " + id + "(1 - 4).");
                    int idEstado = sc.nextInt();
                    if (buscarEstado(idEstado) != null){
                        tarea.setEstado(buscarEstado(idEstado));
                    }
                    else {
                        System.out.println("ID de estado no válido. No se ha guardado el cambio.");
                    }
                }

                System.out.println("¿Desea modificar la categoría de la tarea (s para confirmar)?");
                if (sc.nextLine().equals("s")) {
                    for (Categoria categoria : categorias){
                        categoria.mostrarDatos();
                    }
                    System.out.println("Ingrese la nueva categoría de la tarea " + id + "(1 - 2).");
                    int idCategoria = sc.nextInt();
                    if (buscarCategoria(idCategoria) != null){
                        tarea.setCategoria(buscarCategoria(idCategoria));
                    }
                    else {
                        System.out.println("ID de categoría no válida. No se ha guardado el cambio.");
                    }
                }

                System.out.println("Tarea con ID " + tarea.getId() + " correctamente actualizada.");
                System.out.println();
            }
            else {
                System.out.println("No existe una tarea con el ID " + id + ". Volviendo al menú principal.");
                System.out.println();
            }
        }
        else {
            System.out.println("La lista de tareas esta vacía. Volviendo al menú principal.");
            System.out.println();
        }

    }

    public static void eliminarTarea(){
        if (!tareas.isEmpty()){
            listarTareas();
            System.out.println("Ingrese el ID de la tarea que desea eliminar: ");
            int id = sc.nextInt();

            if (buscarTarea(id) != null){
                Tarea tarea = buscarTarea(id);
                tarea.getUsuario().getTareas().remove(tarea);
                tareas.remove(tarea);

                System.out.println("Tarea correctamente eliminada.");
                System.out.println();
            }
            else {
                System.out.println("El ID introducido no coincide con el ID de ninguna tarea actual. Volviendo al menú principal.");
                System.out.println();
            }
        }
        else {
            System.out.println("La lista de tareas está vacía. Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static void listarTareas(){
        System.out.println("===LISTA DE TAREAS===");
        for (Tarea tarea : tareas){
            tarea.mostrarDatos();
        }
        System.out.println();
    }

    public static void completarTarea(){
        if (!tareas.isEmpty()){
            listarTareas();
            System.out.println("Introduzca el ID de la tarea que desea completar.");
            int id = sc.nextInt();
            sc.nextLine();
            if (buscarTarea(id) != null){
                Tarea tarea = buscarTarea(id);
                tarea.setEstado(buscarEstado(3));
                System.out.println("Tarea " + id + " - " + tarea.getTitulo() + " marcada correctamente como completada.");
                System.out.println();
            }
            else {
                System.out.println("No existe ninguna tarea con el ID " + id + ". Volviendo al menú principal.");
                System.out.println();
            }
        }
        else {
            System.out.println("La lista de tareas está vacía. Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static void listarTareasCategoria(){
        if (!tareas.isEmpty()){
            for (Categoria categoria : categorias){
                categoria.mostrarDatos();
            }
            System.out.println("Ingrese el ID de la categoría de la cual quiere listar las tareas: ");
            int id = sc.nextInt();
            sc.nextLine();
            if (buscarCategoria(id) != null){
                Categoria categoria = buscarCategoria(id);
                System.out.println("===TAREAS DE LA CATEGORÍA " + id + " - " + categoria.getNombre() + "===");
                boolean hayDatos = false;
                for (Tarea tarea : tareas){
                    if (tarea.getCategoria() == categoria){
                        hayDatos = true;
                        tarea.mostrarDatos();
                    }
                }
                if (!hayDatos) {
                    System.out.println("No existen tareas dentro de la categoría seleccionada.");
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("La lista de tareas está vacía. Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static void listarTareasUsuario(){
        if (!usuarios.isEmpty()){
            mostrarUsuarios();
            System.out.println("Ingrese el ID del usuario del que quiere listar las tareas: ");
            int id = sc.nextInt();

            if (buscarUsuario(id) != null){
                Usuario usuario = buscarUsuario(id);
                System.out.println("===TAREAS DEL USUARIO " + id + " - " + usuario.getNombre() + "===");
                if (!usuario.getTareas().isEmpty()){
                    for (Tarea tarea : usuario.getTareas()){
                        tarea.mostrarDatos();
                    }
                }
                else {
                    System.out.println("El usuario seleccionado no tiene tareas asignadas. Volviendo al menú principal.");
                    System.out.println();
                }
            }
            else {
                System.out.println("El ID de usuario ingresado no es válido. Volviendo al menú principal.");
                System.out.println();
            }
        }
        else {
            System.out.println("La lista de usuarios está vacía. Volviendo al menú principal.");
            System.out.println();
        }
    }

    public static Usuario buscarUsuario(int id){
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    public static Estado buscarEstado(int id){
        for (Estado estado : estados){
            if (estado.getId() == id){
                return estado;
            }
        }
        return null;
    }

    public static Categoria buscarCategoria(int id){
        for (Categoria categoria : categorias){
            if (categoria.getId() == id){
                return categoria;
            }
        }
        return null;
    }

    public static Tarea buscarTarea(int id){
        for (Tarea tarea : tareas){
            if (tarea.getId() == id){
                return tarea;
            }
        }
        return null;
    }

    public static List getCategorias(){
        return categorias;
    }

    public static List getEstados(){
        return estados;
    }

    public static List getUsuarios(){
        return usuarios;
    }

    public static List getTareas(){
        return tareas;
    }
}

