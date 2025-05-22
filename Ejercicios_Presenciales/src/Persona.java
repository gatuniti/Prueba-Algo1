/*
Demostración sobre cómo crear una clase. Clase: 21/3/25
 */
public class Persona {
    private String nombre;
    int dni;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int dni) {
        this.dni = dni;
    }

    public int getDNI(){
        return dni;
    }

    public Persona copy(){
        Persona copia = new Persona();
        copia.setNombre(nombre);
        copia.setDNI(dni);
        return copia;
    }
}
