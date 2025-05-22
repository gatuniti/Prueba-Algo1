package IgualdadOrdenCopia;

public class Main {
    public static void main(String[] args) {
        //Pruebas del ejercicio: Arreglo de inmutables
        Persona valentina = new Persona("Valentina", "Di Iorio",
                new Documento(43038738));
        Persona pepe = new Persona("Pepe", "Pipo",
                new Documento(36024815));
        Persona maria = new Persona("Maria", "Pipo",
                new Documento(45369789));
        Persona juan = new Persona("Juan", "Pipo",
                new Documento(30456843));
        Persona carlos = new Persona("Carlos", "Pipo",
                new Documento(32458713));
        Persona[] listaPersonas = {valentina, pepe, maria, juan, carlos};

        for (Persona persona : listaPersonas){
            System.out.println(persona);
        }
        System.out.println("Hola mundo desde Main");

    }
}
