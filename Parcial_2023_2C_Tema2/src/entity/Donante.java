package entity;

public class Donante {
    private final String nombre;
    private final String apellido;
    private int id;

    public Donante(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        String salida = "(" + id + ") " + apellido + ", " + nombre;
        return salida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }
}
