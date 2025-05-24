//Ejercicio: Personajes en juego de rol
public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public abstract void atacar(Personaje contrincante);

    public abstract void defender();

    public void perderVida(int vidaPerdida){
        puntosVida = puntosVida - vidaPerdida;
    }

    public String getNombre(){
        return nombre;
    }

    public int getNivel(){
        return nivel;
    }

    public int getPuntosVida(){
        return puntosVida;
    }
}
