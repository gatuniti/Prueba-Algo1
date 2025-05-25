//Ejercicio: Registro de Estudiantes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroEstudiante {
    private static List<Estudiante> registro = new ArrayList<>();

    public static void registrarEstudiante(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Ingrese el nombre del alumno: ");
            String nombre = scanner.nextLine();
            if(nombre == null || nombre.trim().isEmpty()){
                throw new NombreInvalidoException();
            }

            System.out.println("Ingrese la edad del alumno: ");
            int edad = scanner.nextInt();
            if(edad < 0 || edad > 120){
                throw new EdadInvalidadException();
            }

            System.out.println("Ingrese el promedio del alumno: ");
            double promedio = scanner.nextDouble();
            if(promedio < 0.0 || promedio > 10.0){
                throw new PromedioInvalidoException();
            }
            Estudiante alumno = new Estudiante(nombre, edad, promedio);
            registro.add(alumno);
        }catch (NombreInvalidoException | EdadInvalidadException | PromedioInvalidoException exception){
            System.out.println("Error: " + exception.getMessage());
        }catch (NumberFormatException exception){
            System.out.println("Error: Formato nmérico inválido.");
        }
    }

    public static void mostrarEstudiantes(){
        for(Estudiante estudiante : registro){
            System.out.println(estudiante);
        }
    }
}
