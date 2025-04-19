//Ejercicio Calculadora simple
package Introduccion.src;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();
        System.out.println("Ingrese el operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);
        System.out.println("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        double resultado;
        switch (operador){
            case '+':
                resultado = numero1+numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case '-':
                resultado = numero1-numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case '*':
                resultado = numero1*numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case '/':
                if(numero2==0){
                    System.out.println("Error: No es posible dividir por 0.");
                }else{
                    resultado = numero1/numero2;
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:
                System.out.println("Error: Operador inválido.");
        }
    }
}
