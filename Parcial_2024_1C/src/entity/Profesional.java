package entity;

public class Profesional {
    private final String nombre;
    private final int matricula;

    public Profesional(String nombre, int matricula){
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getMatricula(){
        return this.matricula;
    }

    @Override
    public String toString(){
        String salida = nombre + " [" + matricula + "]";
        return salida;
    }
}
