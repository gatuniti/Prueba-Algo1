package entity;

import java.time.LocalDate;

public class Prestamo {
    private final int id;
    private final LocalDate fechaSolicitud;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    private final Usuario usuario;
    private final Libro libro;

    public Prestamo(int id, Usuario usuario, Libro libro){
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        fechaSolicitud = LocalDate.now();
        fechaDevolucion = null;
        estado = EstadoPrestamo.PENDIENTE;
    }

    @Override
    public String toString() {
        String salida = "Préstamos " + id + "\n" +
                " - Usuario: " + usuario + "\n" +
                " - Libro: " + libro + "\n" +
                " - Estado: " + estado + "\n" +
                " - Fecha de solicitud: " + fechaSolicitud + "\n" +
                " - Fecha de devolución: " + fechaDevolucion;
        return salida;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void fueDevuelto() {
        estado = EstadoPrestamo.DEVUELTO;
        fechaDevolucion = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}
