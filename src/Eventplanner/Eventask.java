package Eventplanner;  // Paquete principal para la aplicación EventPlanner.

/**
 * Clase que representa una tarea dentro de un evento en la aplicación EventPlanner.
 * Permite almacenar la descripción de una tarea y su estado (completa o no).
 */

public class Eventask {

    private String text; // Descripción de la tarea.
    private boolean isCompleted; // Estado de la tarea (true: completada, false: no completada).

    /**
     * Constructor para crear una tarea con su descripción y estado.
     * @param text        Descripción de la tarea.
     * @param isCompleted Estado de la tarea (true: completado, false: no completado).
     */
    public Eventask(String text, boolean isCompleted) {
        this.text = text;
        this.isCompleted = isCompleted;
    }
    // Getter para el texto de la tarea
    public String getText() {
        return text;
    }

    // Setter para el texto de la tarea
    public void setText(String text) {
        this.text = text;
    }

    // Getter para el estado de completado de la tarea
    public boolean isCompleted() {
        return isCompleted;
    }

    // Setter para el estado de completado de la tarea
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * Método para obtener los detalles de la tarea en formato String.
     * Este método retorna los detalles de la tarea, incluyendo la descripción y el estado.
     * @return
     */
    public String toString() {
        // Retorna los detalles de la tarea, mostrando si está completada o no.
        if (isCompleted) {
            return "Tarea: " + text + ", Estado: Completada";
        } else {
            return "Tarea: " + text + ", Estado: No completado";
        }
    }
}










