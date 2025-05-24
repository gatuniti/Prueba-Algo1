//Ejercicio: Personajes en juego de rol
public class Paladin extends Personaje{
    public Paladin(String nombre){
        this.nombre = nombre;
        this.nivel = 0;
        this.puntosVida = 100;
    }

    @Override
    public void atacar(Personaje contrincante) {
        contrincante.perderVida(5);
        System.out.println(this + " atacó a " + contrincante);
    }

    @Override
    public void defender() {
        puntosVida = puntosVida + 2;
        System.out.println(this + " se defendió");
    }

    public String toString(){
        return "Paladín: " + nombre + " [" + nivel + "|" + puntosVida + "/100]";
    }
}
