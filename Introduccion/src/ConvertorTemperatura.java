//Ejercicio Conversión de temperatura
package Introduccion.src;
import java.util.Scanner;

public class ConvertorTemperatura {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la temperatura: ");
        double original = scanner.nextDouble();
        System.out.println("Ingrese la unidad de temperatura (C/F): ");
        char unidad = scanner.next().charAt(0);

        double convertida;
        switch (unidad){
            case 'C':
                convertida = original*9/5+32;
                System.out.println("Temperatura en Fahrenheit: " + convertida + "°F");
                break;
            case 'F':
                convertida = (original-32)*5/9;
                System.out.println("Temperatura en Celsius: " + convertida + "°C");
                break;
            default:
                System.out.println("Error: Unidad inválida.");
        }
    }
}
