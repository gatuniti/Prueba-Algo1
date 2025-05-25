//Ejercicio: Registro de Estudiantes
public class EdadInvalidadException extends RuntimeException {
    public EdadInvalidadException() {
        super("La edad deve estar entre 0 y 120 años.");
    }
}
