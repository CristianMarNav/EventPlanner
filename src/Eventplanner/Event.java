package Eventplanner;  // Paquete que agrupa las clases relacionadas con la planificación de eventos

import Eventplanner.Priority; // Asegúrate de que este import esté presente
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un evento dentro de la aplicación EventPlanner.
 * Permite almacenar los datos básicos de un evento, incluyendo su título
 * fecha, prioridad y las tareas asociadas.
 */
public class Event {

    private String title; // Título del evento.
    private LocalDate date; // Fecha del evento.
    private Priority priority; // Prioridad del evento (HIGH, MEDIUM, LOW)
    private ArrayList<Eventask> task;

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
        this.task = new ArrayList<Eventask>();
    }

    /**
     * Método para agregar una tarea a este evento.
     * @param task Tarea a agregar.
     */
    public void addTask(Eventask task) {
        this.task.add(task);
    }

    /**
     * Metodo para obtener los detalles del evento en formato String.
     *
     * Este método retorna los detalles del evento incluyendo el título, la fecha, la prioridad y el número de tareas
     * asociadas a este evento.
     * @return
     */
    public String toString() {
        return "Evento: " + title + ", Fecha: " + date + ", Prioridad: " + priority + ", Tareas: " + task.size();
    }

}
