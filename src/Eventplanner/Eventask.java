package Eventplanner;  // Paquete principal para la aplicación EventPlanner.

/**
 * Clase que representa una tarea dentro de un evento en la aplicación EventPlanner.
 * Permite almacenar la descripción de una tarea y su estado (completa o no).
 */

public class Eventask {

    private String taskName; // Descripción de la tarea.
    private boolean isCompleted; // Estado de la tarea (true: completada, false: no completada).

    /**
     * Constructor para crear una tarea con su descripción y estado.
     * @param taskName Descripción de la tarea.
     * @param isCompleted Estado de la tarea (true: completado, false: no completado).
     */
    public Eventask(String taskName, boolean isCompleted) {
        this.taskName = taskName; // Inicializamos el nombre de la tarea.
        this.isCompleted = isCompleted; // Inicializamos el estado de la tarea.
    }

    // Getter y Setter para el nombre de la tarea.
    public String getTaskName() {
        return taskName; // Devuelve el nombre de la tarea.
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName; // Establece el nombre de la tarea.
    }

    // Getter y Setter para el estado de la tarea.
    public boolean isCompleted() {
        return isCompleted; // Devuelve el estado de la tarea (completada o no).
    }

    /**
     * Estableces el estado de la tarea.
     * @param isCompleted Estado de la tarea (completada o no),
     */
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted; // Establece el estado de la tarea.
    }

    /**
     * Método para cambiar el estado de la tarea (marcar como completada o no).
     */
    public void toggleTasKStatus() {
        this.isCompleted = !this.isCompleted; // Invertimos el valor de isCompleted.
    }

    /**
     * Método para obtener los detalles de la tarea en formato String incluyendo la descripción y el estado.
     * @return  Los detalles de la tarea como String.
     */
    public String toString() {
        // Retorna los detalles de la tarea, mostrando si está completada o no.
        if (isCompleted) {
            return "Tarea: " + taskName + ", Estado: Completada"; // Si la tarea está completada.
        } else {
            return "Tarea: " + taskName + ", Estado: No completado"; // Si la tarea no esta completada.
        }
    }

    /**
     * Método para marcar la tarea como completada.
     * @param status Estado de la tarea (completada o no).
     */
        public void markTaskCompleted(boolean status) {
            this.isCompleted = status; // Actualiza el estado de la tarea a completada o no.
    }
}





