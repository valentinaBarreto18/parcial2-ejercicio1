package org.example.Domain;


public class ServicioPeluqueria {
    private int id;
    private String nombreServicio;
    private String descripcion;
    private int precio;

    public ServicioPeluqueria(int id, String nombreServicio, String descripcion, int precio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    // Setters
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;  // Este método es clave
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}


