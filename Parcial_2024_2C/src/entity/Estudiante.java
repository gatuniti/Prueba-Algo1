package entity;

public class Estudiante extends Usuario{

    public Estudiante(String nombre, int dni){
        super(nombre, dni);
    }

    @Override
    public boolean puedePedirPrestamo() {
        if(getCantPrestamosActivos() < 2){
            return true;
        }else{
            return false;
        }
    }
}
