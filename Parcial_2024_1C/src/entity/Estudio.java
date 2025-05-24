package entity;

public abstract class Estudio {
    private Boolean realizado = false;

    public void realizar(Paciente paciente, Profesional profesional){
        this.realizado = true;
        Notificador.notificar(paciente, profesional, this);
    }

    public abstract String getNombre();

    public abstract String getDescripcion();

    @Override
    public String toString() {
        String salida;
        if(realizado){
            salida = "  - " + getNombre() + ": " + getDescripcion() + " (REALIZADO)";
        }else{
            salida = "  - " + getNombre() + ": " + getDescripcion() + " (PENDIENTE)";
        }
        return salida;
    }
}
