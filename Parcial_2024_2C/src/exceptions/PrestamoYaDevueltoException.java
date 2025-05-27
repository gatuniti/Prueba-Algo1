package exceptions;
//Pude haber usado IllegalStateException
public class PrestamoYaDevueltoException extends RuntimeException {
    public PrestamoYaDevueltoException() {
        super("El préstamo ya ha sido devuelto.");
    }
}
