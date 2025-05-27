package exceptions;

public class UsuarioYaRegistradoException extends RuntimeException {
    public UsuarioYaRegistradoException() {
        super("El usuario ya está registrado en el sistema.");
    }
}
