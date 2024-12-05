package Eventplanner;  // Paquete principal para ejecutar la aplicación EventPlanner

import Eventplanner.Priority; // Importa la clase Priority para gestionar las prioridades de los eventos.
import java.time.LocalDate; // Importa LocalDate para manejar fechas en formato (yyyy-MM-dd).
import java.time.format.DateTimeFormatter; //  Importa DateTimeFormatter para definir el formato de la fehca al leer.
import java.util.Scanner; // Importa Scanner para leer datos desde la consola.
import java.util.ArrayList; // Importa ArrayList para almacenar dinámicamente los objetos de eventos en una lista.

/**
 * Clase principal que maneja el flujo de la aplicación EventPlanner.
 * El usuario puede interactuar con los eventos y las tareas asociadas a través de un menú interactivo.
 * Esta clase contiene el método principal que ejecuta el menú y las interacciones del usuario.
 */
public class Main {

    private static ArrayList<Event> eventList = new ArrayList<>(); // Lista para almacenar los eventos.

    /**
     * El método principal que ejecuta el programa y muestra el menú interactivo.
     * Dependiendo de la opción selleccionada por el usuario, se llamarán diferentes métodos
     * para manejar eventos y tareas.
     */
    public static void main(String[]args) {
        // Creamos un objeto Scanner para leer entradas del usuario.
        Scanner input = new Scanner(System.in);

        // Definimos el formato de la fecha, el cual será 'yyyy-MM-dd'.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Variable para almacenar la opción seleccionada por el usuario
        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

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
            input.nextLine(); // Limpiamos el buffer para evitar problemas con entradas posteriores.

            // Imprimir la opción seleccionada.
            System.out.println("Opción seleccionada: " + opcion);

            // Procesamos la opción seleccionada por el usuario.
            switch (opcion) {
                case 1:
                    // Llamamos al método para añadir eventos.
                    System.out.println("Añadir evento");

                    // Pedimos al usuario que ingrese los datos del evento.
                    System.out.println("Introduce el título del evento: ");
                    String titulo = input.nextLine(); // Leemos el título del evento.

                    // Declaramos la variable fechaStr para almacenar la fecha ingresada por el usuario.
                    String fechaStr;

                    // Pedimos la fecha del evento en formato yyyy-MM-dd.
                    System.out.println("Introduce la fecha del evento (formato YYYY-MM-DD): ");
                    fechaStr = input.nextLine(); // Leemos la fecha ingresada por el usuario.

                    // Intentamos convertir la fecha ingresada a un objeto Localdate.
                    LocalDate fecha = null;
                    while (fecha == null) {
                        try {
                            fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Convertimos la fecha a LocalDate.
                        } catch (Exception e) {
                            System.out.println("La fecha ingresada es inválida. Por favor, usa el formato correcto (YYYY-MM-DD).");
                            System.out.println("Introduce nuevamente la fecha del evento: ");
                            fechaStr = input.nextLine(); // Volvemos a pedir la fecha.
                        }
                    }

                    // Pedimos la prioridad del evento.
                    System.out.println("Introduce la prioridad del evento (HIGH, MEDIUM,LOW): ");
                    String prioridad = input.nextLine(); // Leemos la prioridad.

                    //Creamos el nuevo evento.
                    Event nuevoEvento = new Event(titulo, fecha, Priority.valueOf(prioridad.toUpperCase()));
                    eventList.add(nuevoEvento);

                    // Confirmamos que el evento ha sido añadido.
                    System.out.println("Evento añadido: " + nuevoEvento);
                    break;

                case 2:
                    // Aquí llamaremos al método para borrar eventos.
                    System.out.println("Borrar evento");


                    // Verificamos si la lista de eventos está vacia.
                    if (eventList.isEmpty()) {
                        System.out.println("No hay eventos para eliminar");
                    } else {
                        // Mostramos los eventos disponibles para que el usuario elija uno a eliminar.
                        System.out.println("Eventos disponibles para eliminar:");

                        // Iteramos sobre la lista de eventos y los mostramos al usuario con un número.
                        // Esto ayuda a que el usuario elimine facilmente el evento.
                        for (int i = 0; i < eventList.size(); i++) {
                            System.out.println(i + 1 + ". " + eventList.get(i)); // Mostramos el evento con su número.
                        }

                        // Pedimos al usuario que ingrese el número del evento que desea eliminar.
                        // Este número se usará para identificar y eliminar el evento de la lista.
                        System.out.println("Introduce el número del evento que deseas eliminar: ");
                        int eventToRemove = input.nextInt(); // Leemos la opción del evento a eliminar.
                        input.nextLine(); // Limpiamos el buffer para evitar problemas con entradas posteriores.

                        // Verificamos que el número ingresado sea válido.
                        // Si el número es válido, eliminamos el evento de la lista.
                        if (eventToRemove > 0 && eventToRemove <= eventList.size()) {
                            // Eliminamos el evento de la lista utilizando el índice (restamos 1 porque las listas empiezan en 0).
                            eventList.remove (eventToRemove -1);
                            System.out.println("Evento eliminado"); // Confirmamos que el evento fue eliminado.
                        } else {
                            // Si el número no es válido, mostramos un mensaje de error.
                            System.out.println("Número de evento inválido.");
                        }
                    }
                    break;

                case 3:
                    // Aquí llamaremos al método para listar eventos.
                    System.out.println("Listar eventos");
                    for (Event evento : eventList) {
                        System.out.println(evento); // El método toString() de la clase Event se encargará de mostrar el evento.
                    }
                    break;

                case 4:
                    // Aquí llamaremos al método para marcar o desmarcar una tarea de un evento
                    System.out.println("Marcar/desmarcar tarea de evento");
                    break;

                case 5:
                    // Aquí si el usuario elige salir, terminamos el programa.
                    System.out.println("Saliendo...");
                    break;

                default:
                    // En caso de que el usuario ingrese una opción no válida.
                    System.out.println("Opción no válida");

            }
        } while (opcion !=5); // Continuar mostrando el menú mientas la opción no sea 5.

        input.close(); // Cerramos el objeto Scanner al finalizar el programa.
    }
}
