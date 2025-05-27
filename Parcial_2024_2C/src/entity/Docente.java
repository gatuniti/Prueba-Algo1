package entity;

import java.time.LocalDate;

public class Docente extends Usuario{
    private final LocalDate fechaContratacion;

    public Docente(String nombre, int dni, LocalDate fechaContratacion){
        super(nombre, dni);
        this.fechaContratacion = fechaContratacion;
    }

    public int calcularAntiguedad(){
        LocalDate hoy = LocalDate.now();
        int antiguedad = hoy.getYear() - fechaContratacion.getYear();

        //Resto un año si todavía no llegó el aniversario del día de contratación
        if(hoy.getMonthValue() < fechaContratacion.getMonthValue() ||
                (hoy.getMonthValue() == fechaContratacion.getMonthValue() &&
                hoy.getDayOfMonth() < fechaContratacion.getDayOfMonth())){
            antiguedad--;
        }

        return antiguedad;
    }

    @Override
    public boolean puedePedirPrestamo() {
        if(getCantPrestamosActivos() < calcularAntiguedad()){
            return true;
        }else{
            return false;
        }
    }
}
