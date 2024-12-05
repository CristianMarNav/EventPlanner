package Eventplanner;  // Paquete principal para ejecutar la aplicación EventPlanner

import java.time.LocalDate; // Importa LocalDate para manejar fechas en formato (yyyy-MM--dd).
import java.time.format.DateTimeFormatter; //  Importa DateTimeFormatter para definir el formato de la fehca al leer.
import java.util.Scanner; // Importamos Scanner para leer datos desde la consola.

/**
 * Clase principal que maneja el flujo de la aplicación EventPlanner.
 * El usuario puede interactuar con los eventos y las tareas asociadas a través de un menú interactivo.
 * Esta clase contiene el método principal que ejecuta el menú y las interacciones del usuario.
 */
public class Main {

    /**
     * El método principal que ejecuta el programa y muestra el menú interactivo.
     * Dependiendo de la opción selleccionada por el usuario, se llamarán diferentes métodos
     * para manejar eventos y tareas.
     */
    public  static void main(String[]args) {
        // Creamos un objeto Scanner para leer entradas del usuario.
        Scanner input = new Scanner(System.in);

        // Definimos el formato de la fecha, el cual será 'yyyy-MM-dd'.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Variable para almacenar la opción seleccionada por el usuario
        int opcion = input.nextInt(); // Variable para almacenar la opción seleccionada por el usuario.
        input.nextLine(); // Limpiar el buffer para evitar problemas con entradas posteriores.

        // Bucle do-while que continuará mostrando el menú hasta que el usuario elija salir.
        do {
            // Mostrar opciones del menú.
            System.out.println("Bienvenido a Event Planner. Seleccione una opción: ");
            System.out.println("[1] Añadir evento 🗓️");
            System.out.println("[2] Borrar evento 🗑️");
            System.out.println("[3] Listar eventos 🗒️");
            System.out.println("[4] Marcar/desmarcar tarea de un evento como completada  ✅ ❌");
            System.out.println("[5] Salir 🚪");

            // Leemos la opción seleccionada por el usuario.
            System.out.println("Elige una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpio el buffer para evitar problemas con entradas posteriores.

            // Procesamos la opción seleccionada por el usuario.
            switch (opcion) {
                case 1:
                    // Llamamos al método para añadir eventos.
                    System.out.println("Añadir evento");

                    // Pedimos al usuario que ingrese los datos del evento.
                    System.out.println("Introduce el título del evento: ");
                    String titulo = input.nextLine(); // Leemos el título del evento.

                    System.out.println("Introduce la fecha del evento (formato YYYY-MM_DD): ");
                    String fechaStr = input.nextLine(); // Leemos la fecha

                    // Intentamos convertir la fecha ingresada a un objeto LocalDate.
                    LocalDate fecha = LocalDate.parse(fechaStr, formatter); // Convertimos la fecha a LocalDate.

                    // Pedimos la prioridad del evento.
                    System.out.println("Introduce la prioridad del evento (HIGH, MEDIUM,LOW): ");
                    String prioridad = input.nextLine(); // Leemos la prioridad.

                    Event nuevoEvento = new Event(titulo, fecha, Priority.valueOf(prioridad));

                    // Confirmamos que el evento ha sido añadido.
                    System.out.println("Evento añadido: " + nuevoEvento);

                    break;

                case 2:
                    // Aquí llamaremos al método para borrar eventos.
                    System.out.println("Borrar evento");
                    break;

                case 3:
                    // Aquí llamaremos al método para listar eventos.
                    System.out.println("Listar eventos");
                    break;

                case 4:
                    // Aquí llamaremos al método para marcar o desmarcar una tarea de un evento
                    System.out.println("Marcar/desmarcar tarea de evento");
                    break;

                case 5:
                    // Aquí si el usuario elige salir, terminamos el programa.
                    System.out.println("Saliendo");
                    break;

                default:
                    // En caso de que el usuario ingrese una opción no válida.
                    System.out.println("Opción no válida");

            }
        } while (opcion !=5); // Continuar mostrando el menú mientas la opción no sea 5.

        input.close(); // Cerramos el objeto Scanner al finalizar el programa.

    }
}
