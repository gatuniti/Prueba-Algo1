//Ejercicio Tabla de multiplicar
package Introduccion.src;

import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        double numero = scanner.nextDouble();

        System.out.println("Tabla de multiplicar del "+numero+":");
        for(int i = 1; i<=10; i++){
            double resultado = numero*i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
}
