//Ejercicio: Arreglo de inmutables
package IgualdadOrdenCopia;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final Documento documento;

    public Persona(String nombre, String apellido, Documento documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + documento.getNumeroDoc();
    }
}
