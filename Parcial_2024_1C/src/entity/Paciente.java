package entity;

public class Paciente {
    private final String nombre;
    private final int dni;
    private int cantidadEstudios;
    private int cantidadEstudiosRealizados;

    public Paciente(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
        this.cantidadEstudios = 0;
        this.cantidadEstudiosRealizados = 0;
    }

    public void agendarEstudio(){
        cantidadEstudios++;
    }

    public void realizarEstudio(){
        cantidadEstudiosRealizados++;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDni(){
        return this.dni;
    }

    public int getCantidadEstudios() {
        return cantidadEstudios;
    }

    public int getCantidadEstudiosRealizados() {
        return cantidadEstudiosRealizados;
    }

    @Override
    public String toString(){
        String salida = nombre + " [" + dni + "]";
        return salida;
    }
}
