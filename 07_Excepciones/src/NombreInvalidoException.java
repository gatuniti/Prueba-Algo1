//Ejercicio: Registro de Estudiantes
public class NombreInvalidoException extends RuntimeException {
    public NombreInvalidoException() {
        super("El nombre no puede estar vacío.");
    }
}
