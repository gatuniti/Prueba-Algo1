//Ejercicio: Personajes en juego de rol
//Ejercicio: Personajes en juego de rol II
 class Wizard extends Personaje implements PersonajesAtaqueDistancia{
    public Wizard(String nombre){
        this.nombre = nombre;
        this.nivel = 0;
        this.puntosVida = 100;
    }

    @Override
    public void atacar(Personaje contrincante) {
        contrincante.perderVida(3);
        System.out.println(this + " atacó a " + contrincante);
    }

    @Override
    public void defender() {
        puntosVida = puntosVida + 3;
        System.out.println(this + " se defendió");
    }

    @Override
    public void atacarDistancia(Personaje contrincante) {
        contrincante.perderVida(3);
        System.out.println(this + " atacó a distancia a " + contrincante);
    }

    public String toString(){
        return "Wizard: " + nombre + " [" + nivel + "|" + puntosVida + "/100]";
    }
}
