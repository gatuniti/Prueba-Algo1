package exceptions;
//Pude haber usado IllegalStateException
public class LibroNoDisponibleException extends RuntimeException {
    public LibroNoDisponibleException() {
        super("El libro no está disponible para prestar actualmente, ya ha sido prestado.");
    }
}
