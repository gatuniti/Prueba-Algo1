//Ejercicio: Registro de Estudiantes
public class Estudiante {
    private final String nombre;
    private int edad;
    private double promedio;

    public Estudiante(String nombre, int edad, double promedio){
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Estudiante " + nombre + " (" + edad + ") con promedio " + promedio + ".";
    }
}
