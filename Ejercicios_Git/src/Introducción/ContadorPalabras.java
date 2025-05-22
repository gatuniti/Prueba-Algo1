//Ejercicio Contador de palabras especial
import java.util.Scanner;

public class ContadorPalabras {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una frase: ");
        String frase = scanner.nextLine();

        System.out.println("Ingrese un separador: ");
        String separador = scanner.nextLine();

        String[] palabras = frase.split(separador);

        System.out.println("Cantidad de palabras: " + palabras.length);
    }
}
