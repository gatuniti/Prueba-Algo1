//Ejercicio Suma de número pares
package Introduccion.src;

import java.util.Scanner;

public class SumaNumerosPares {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número positivo: ");
        int numero = scanner.nextInt();

        int resultado = 0;

        if(numero>0){
            int aux = 2;
            for (int i = 2; i <= numero; i+=2){
                resultado += i;
            }
            System.out.println("La suma de los números pares del 1 al "+numero+" es: "+resultado);
        }else{
            System.out.println("Error: El número no es positivo");
        }
    }
}
