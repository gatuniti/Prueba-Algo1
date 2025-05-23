//Ejercicio: Arreglo de inmutables
//Ejercicio: Copia profunda sin Cloneable
public class Persona implements Cloneable{
    private String nombre;
    private String apellido;
    private int edad;
    private Documento documento;

    public Persona(){}

    public Persona(String nombre, String apellido, int edad, Documento documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public Persona(Persona original){
        this.nombre = original.nombre;
        this.apellido = original.apellido;
        this.edad = original.edad;
        this.documento = original.documento.clone();
    }

    public Documento getDocumento() {
        return this.documento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNroDocumento(int nroDocumento) {
        this.documento.setNumero(nroDocumento);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + ", " + this.edad + ", " + this.documento.getNumeroDoc();
    }

    @Override
    public Persona clone() {
        try {
            Persona copia = (Persona) super.clone();    // Copia superficial de persona
            copia.documento = this.documento.clone();   // Copia profunda de Documento
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Persona copiaSuperficial() {
        Persona copia = new Persona();
        copia.nombre = this.nombre;
        copia.edad = this.edad;
        copia.documento = this.documento;   // Se asigna la misma referencia original
        return copia;
    }

    public static Persona copiaProfunda(Persona original){
        return new Persona(original.nombre, original.apellido, original.edad, original.documento.clone());
    }
}
