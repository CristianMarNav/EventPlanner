package Eventplanner;  // Paquete que agrupa las clases relacionadas con la planificación de eventos.

import Eventplanner.Priority; // // Importa la clase Priority para manejar las prioridades de los eventos.
import java.time.LocalDate; // Importa LocalDate para manejar fechas en formato (YYYY-MM--DD).
import java.util.ArrayList; // Importa ArrayList para manejar colecciones dinámicas de elementos.

/**
 * Clase que representa un evento dentro de la aplicación EventPlanner.
 * Permite almacenar los datos básicos de un evento, incluyendo su título, fecha, prioridad y las tareas asociadas.
 */
public class Event {

    private String title; // Título del evento.
    private LocalDate date; // Fecha del evento.
    private Priority priority; // Prioridad del evento (HIGH, MEDIUM, LOW).
    private ArrayList<Eventask> task; // Lista que almacena las tareas asociadas al evento.

    /**
     * Constructor para crear un evento con los datos básicos.
     * @param title Título del evento.
     * @param date Fecha del evento.
     * @param priority Prioridad del evento.
     */

    public Event(String title, LocalDate date, Priority priority) {

        this.title = title;
        this.date = date;
        this.priority = priority;
        this.task = new ArrayList<>(); // Inicializamos la lista de tareas.

        // Agregamos una tarea predeterminada al evento, para evitar que un evento se quede sin tareas.
        Eventask defaultTask = new Eventask("Tarea predeterminada", false);  // Tarea no completada.
        this.addTask(defaultTask);  // Añadimos la tarea predeterminada.
    }

    // Getter para el título del evento.
    public String getTitle() {
        return title;
    }

    // Setter para el título del evento.
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter para la fecha del evento.
    public LocalDate getDate() {
        return date;
    }

    // Setter para la fecha del evento.
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter para la prioridad del evento.
    public Priority getPriority() {
        return priority;
    }

    // Setter para la prioridad del evento.
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    // Getter para la lista de tareas.
    public ArrayList<Eventask> getTasks() {
        return task;
    }

    // Setter para la lista de tareas.
    public void setTasks(ArrayList<Eventask> tasks) {
        this.task = tasks;
    }

    /**
     * Método para agregar una tarea a este evento.
     * @param task Tarea a agregar.
     */
    public void addTask(Eventask task) {
        this.task.add(task);
    }

    /**
     * Método para obtener los detalles del evento en formato String.
     * Este método retorna los detalles del evento incluyendo el título, la fecha,
     * la prioridad y el número de tareas asociadas a este evento.
     * @return Los detalles del evento como String.
     */
    public String toString() {
        return "Evento: " + title + ", Fecha: " + date + ", Prioridad: " + priority + ", Tareas: " + task.size();
    }

    /**
     * Método para obtener las tareas asociadas a este evento en formato String.
     * @return String con los detalles de las tareas.
     */
    private String getTasksDetails() {
        StringBuilder tasksDetails = new StringBuilder();

        // Recorremos la lista de tareas y las agregamos al StringBuilder.
        for (Eventask task : task) {
            tasksDetails.append(task.toString()).append("\n");
        }
        return tasksDetails.toString();
    }
}
