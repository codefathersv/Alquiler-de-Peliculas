
package model;

public class dbo_alquiler {
    private int id_alquiler;
    private dbo_peliculas pelicula;
    private dbo_clientes cliente;
    private String descripcion;
    private String fecha_alquiler;
    private String fecha_entrega;
    private double costo;
    private dbo_estado estado;

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public dbo_peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(dbo_peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public dbo_clientes getCliente() {
        return cliente;
    }

    public void setCliente(dbo_clientes cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public dbo_estado getEstado() {
        return estado;
    }

    public void setEstado(dbo_estado estado) {
        this.estado = estado;
    }
    
    
}
