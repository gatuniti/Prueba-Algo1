package entity;

public abstract class Usuario {
    private final String nombre;
    private final int dni;
    private int cantPrestamosActivos;
    private int cantPrestamosRealizados;

    public Usuario(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
        cantPrestamosActivos = 0;
        cantPrestamosRealizados = 0;
    }

    public abstract boolean puedePedirPrestamo();

    public void nuevoPrestamo(){
        cantPrestamosActivos++;
        cantPrestamosRealizados++;
    }

    public void nuevaDevolucion(){
        cantPrestamosActivos--;
    }

    @Override
    public String toString() {
        String salida = nombre + " (" + dni + ")";
        return salida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getCantPrestamosActivos() {
        return cantPrestamosActivos;
    }

    public int getCantPrestamosRealizados() {
        return cantPrestamosRealizados;
    }
}
