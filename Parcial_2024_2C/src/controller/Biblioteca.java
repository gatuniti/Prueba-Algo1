package controller;

import entity.*;
import exceptions.LibroNoDisponibleException;
import exceptions.LimitePrestamosExcedidoException;
import exceptions.PrestamoYaDevueltoException;
import exceptions.UsuarioYaRegistradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private final String nombre;
    private Map<Integer, Usuario> usuarios;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        usuarios = new HashMap<>();
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public boolean registrarUsuario(Usuario usuario){
        try {
            if(usuarios.containsKey(usuario.getDni())){
                throw new UsuarioYaRegistradoException();
            }
            usuarios.put(usuario.getDni(), usuario);
            return true;
        }catch (UsuarioYaRegistradoException exception){
            System.out.println("Error: " + exception);
            System.out.println("Detalle: El usuario es " + usuario + ".");
            return false;
        }
    }

    public Docente registrarDocente(String nombre, int dni, LocalDate fecha) {
        Docente docenteNuevo = new Docente(nombre, dni, fecha);
        boolean seRegistro = registrarUsuario(docenteNuevo);
        if(seRegistro){
            return docenteNuevo;
        }else{
            return null;
        }

    }

    public Estudiante registrarEstudiante(String nombre, int dni) {
        Estudiante estudianteNuevo = new Estudiante(nombre, dni);
        boolean seRegistro = registrarUsuario(estudianteNuevo);
        if(seRegistro){
            return estudianteNuevo;
        }else{
            return null;
        }
    }

    public Libro donarLibro(String nombre, String autor) {
        Libro libroNuevo = new Libro(nombre, autor, true);
        //Veo si no es único:
        int indiceLibro = libros.indexOf(libroNuevo);
        if(indiceLibro > 0){
            libroNuevo.setEsUnico(false);
            libros.get(indiceLibro).setEsUnico(false);
        }

        libros.add(libroNuevo);
        return libroNuevo;
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        try{
            //Reviso que el usuario pueda pedir otro préstamo:
            if(!(usuario.puedePedirPrestamo())){
                throw new LimitePrestamosExcedidoException();
            }
            //Reviso que el libro esté disponible:
            if(libro.getEstado() == EstadoLibro.PRESTADO){
                throw new LibroNoDisponibleException();
            }

            Prestamo prestamoNuevo = new Prestamo(usuario, libro);
            prestamos.add(prestamoNuevo);

            usuario.nuevoPrestamo();
            libro.sePresto();

            Notificador.notificarPrestamo(usuario, libro);

            return prestamoNuevo;

        }catch (LimitePrestamosExcedidoException exception){
            System.out.println("Error: " + exception);
            System.out.println("Detalle: El usuario es " + usuario);
        }catch (LibroNoDisponibleException exception){
            System.out.println("Error: " + exception);
            System.out.println("Detalle: El libro es " + libro);
        }
        return null;
    }

    public void devolverPrestamo(Prestamo prestamo) {
        try{
            if(prestamo.getEstado() == EstadoPrestamo.PENDIENTE){
                prestamo.fueDevuelto();
                prestamo.getUsuario().nuevaDevolucion();
                prestamo.getLibro().seDevolvio();
            }else{
                throw new PrestamoYaDevueltoException();
            }
        }catch (PrestamoYaDevueltoException exception){
            System.out.println("Error: " + exception);
            System.out.println("Detalle: El prestamo es " + prestamo);
        }


    }

    public void mostrarPrestamos() {
        for(Prestamo prestamo : prestamos){
            System.out.println(prestamo);
        }
    }

    public void mostrarPrestamosActivos() {
        for(Prestamo prestamo : prestamos){
            if(prestamo.getEstado() == EstadoPrestamo.PENDIENTE){
                System.out.println(prestamo);
            }
        }
    }

    public void mostrarUsuariosConPrestamos(int prestamos) {
        for(Usuario usuario : usuarios.values()){
            if(usuario.getCantPrestamosRealizados() >= prestamos){
                System.out.println(usuario);
            }
        }
    }
}
