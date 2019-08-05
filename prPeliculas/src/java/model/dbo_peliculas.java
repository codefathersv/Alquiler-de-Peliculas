
package model;

public class dbo_peliculas {
    private int id_pelicula;
    private String nombre_pelicula;
    private String sinopsis;
    private dbo_clasificacion clasificacion;
    private dbo_categoria categoria;
    private int age_estreno;

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public dbo_clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(dbo_clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public dbo_categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(dbo_categoria categoria) {
        this.categoria = categoria;
    }

    public int getAge_estreno() {
        return age_estreno;
    }

    public void setAge_estreno(int age_estreno) {
        this.age_estreno = age_estreno;
    }

    
    
}
