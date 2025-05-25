//Ejercicio: Registro de Estudiantes
public class PromedioInvalidoException extends RuntimeException {
    public PromedioInvalidoException() {
        super("El promedio debe estar entre las notas 0.0 y 10.0.");
    }
}
