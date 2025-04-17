//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Clase: 21/3/25
         */
        /*
        Persona pepa = new Persona();
        pepa.setNombre("Pepa");
        pepa.setDNI(22222222);
        System.out.println(pepa.getNombre());
        System.out.println(pepa.getDNI());
        Persona pepa2 = pepa.copy();
        System.out.println(pepa2.getNombre());
        pepa2.setNombre("Pepa2");
        System.out.println(pepa2.getNombre());
        System.out.println(pepa2.getDNI());
        System.out.println(pepa.getNombre());
         */

        /*
        Clase: 1/4/25
         */
        Marcador marcador1 = new Marcador("rojo");
        System.out.println(marcador1.getColor()); //rojo
        System.out.println(marcador1.getCarga()); //0.0
        System.out.println(marcador1.estaDisponible()); //false
        marcador1.recargar(0.5); //0.0+0.5=0.5
        System.out.println(marcador1.getCarga()); //0.5
        marcador1.recargar(0.3); //0.5+0.3=0.8
        System.out.println(marcador1.getCarga()); //0.8
        marcador1.recargar(0.8); //0.8+0.8=1.6
        System.out.println(marcador1.getCarga()); //1.0
        System.out.println(marcador1.estaDisponible()); //true
        marcador1.seDanio();
        System.out.println(marcador1.estaDisponible()); //false
        System.out.println(marcador1); //color: rojo, carga: 1.0, daniado: true
        marcador1.seReparo();
        System.out.println(marcador1); //color: rojo, carga: 1.0, daniado: false
    }
}