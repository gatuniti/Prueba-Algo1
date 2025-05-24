package entity;

public class EstudioLaboratorio extends Estudio {
    private final int cantidad;

    public EstudioLaboratorio(int cantidad) {
        super();
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String getNombre() {
        return "Laboratorio";
    }

    @Override
    public String getDescripcion() {
        return String.format("Estudio de laboratorio con %d items analizados", cantidad);
    }
}
