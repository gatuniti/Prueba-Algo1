public class Main {
    public static void main(String[] args) {
        //Pruebas del ejercicio: Arreglo de inmutables
//        Persona valentina = new Persona("Valentina", "Di Iorio",
//                new Documento(43038738));
//        Persona pepe = new Persona("Pepe", "Pipo",
//                new Documento(36024815));
//        Persona maria = new Persona("Maria", "Pipo",
//                new Documento(45369789));
//        Persona juan = new Persona("Juan", "Pipo",
//                new Documento(30456843));
//        Persona carlos = new Persona("Carlos", "Pipo",
//                new Documento(32458713));
//        Persona[] listaPersonas = {valentina, pepe, maria, juan, carlos};
//
//        for (Persona persona : listaPersonas){
//            System.out.println(persona);
//        }
//
//        carlos.getDocumento().renovarDocumento();
//        juan.getDocumento().setFechas(LocalDate.now().plusDays(1));
//
//        for (Persona persona : listaPersonas){
//            System.out.println(persona);
//        }

        //Pruebas del ejercicio: Comparación de Estudiantes
//        EstudianteGrado valen = new EstudianteGrado("Valentina", "Lic. Ciencia de Datos", 22, 1313);
//        EstudianteGrado pepe = new EstudianteGrado("pepe", "Lic. Ciencia de Datos", 86, 568);
//
//        EstudiantePosgrado valen2 = new EstudiantePosgrado("Valentina", "Lic. Ciencia de Datos", 22, 1313);
//        EstudiantePosgrado pepe2 = new EstudiantePosgrado("Valentina", "Lic. Ciencia de Datos", 22, 1313);
//
//        Estudiante valen3 = new Estudiante("Valentina", 22, 1313);
//        Estudiante pepe3 = new Estudiante("pepe", 86, 1313);
//
//        if(valen.equals(valen2)){
//            System.out.println("valen y valen2 son iguales");
//        }else{
//            System.out.println("valen y valen2 no son iguales");
//        }
//        if(valen.equals(pepe)){
//            System.out.println("valen y pepe son iguales");
//        }else{
//            System.out.println("valen y pepe no son iguales");
//        }
//        if(valen2.equals(pepe2)){
//            System.out.println("valen2 y pepe2 son iguales");
//        }else{
//            System.out.println("valen2 y pepe2 no son iguales");
//        }
//        if(valen3.equals(pepe3)){
//            System.out.println("valen3 y pepe3 son iguales");
//        }else{
//            System.out.println("valen3 y pepe3 no son iguales");
//        }
//        if(valen2 == pepe2){
//            System.out.println("valen2 y pepe2 son iguales");
//        }else{
//            System.out.println("valen2 y pepe2 no son iguales");
//        }

        //Pruebas ejercicio: Copia profunda sin Cloneable

//        Persona valen = new Persona("Valentina", "Di Iorio", 22,
//                new Documento(43038738));
//        Persona valen2 = new Persona(valen);
//        Persona valen3 = Persona.copiaProfunda(valen);
//
//        System.out.println(valen);
//        System.out.println(valen2);
//        System.out.println(valen3);
//
//        valen.setEdad(23);
//        valen.getDocumento().setNumero(33333333);
//
//        System.out.println(valen);
//        System.out.println(valen2);
//        System.out.println(valen3);


    }
}
