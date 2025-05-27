package entity;

public class Notificador {
    public static void notificarPrestamo(Usuario usuario, Libro libro){
        System.out.println("Notificando al usuario " + usuario + " sobre el préstamo del libro " + libro + ".");
    }
}
