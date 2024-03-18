package com.example.vshop.GestionContenido;

public class Tienda {
    private String idTienda;
    private String nombreTienda;
    private String descripcion;
    private String direccion;
    private Estilo estilo;

    public Tienda(String idTienda, String nombreTienda, String descripcion, String direccion, Estilo estilo) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.estilo = estilo;
    }

    public Tienda() {
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
}
