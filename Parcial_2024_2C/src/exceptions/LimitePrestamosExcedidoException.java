package exceptions;
//Pude haber usado IllegalStateException
public class LimitePrestamosExcedidoException extends RuntimeException {
    public LimitePrestamosExcedidoException() {
        super("El usuario ya ha pasado el límite de libros que puede pedir prestado.");
    }
}
