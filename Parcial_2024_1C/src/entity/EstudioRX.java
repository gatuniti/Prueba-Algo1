package entity;

public class EstudioRX extends Estudio {
    private final ZonaCuerpo zonaCuerpo;

    public EstudioRX(ZonaCuerpo zonaCuerpo) {
        super();
        this.zonaCuerpo = zonaCuerpo;
    }

    public EstudioRX(String zonaCuerpoString){
        this.zonaCuerpo = ZonaCuerpo.valueOf(zonaCuerpoString.toUpperCase());
    }

    public ZonaCuerpo getZonaCuerpo() {
        return zonaCuerpo;
    }

    @Override
    public String getNombre() {
        return "RX";
    }

    @Override
    public String getDescripcion() {
        return String.format("Estudio de imagen RX de %s", zonaCuerpo.name().toLowerCase());
    }
}
