package com.example.vshop.GestionContenido;

public class Aptitud {
    private String idAptitud;
    private String nombreAptitud;
    private String descripcion;

    public String getIdAptitud() {
        return idAptitud;
    }

    public void setIdAptitud(String idAptitud) {
        this.idAptitud = idAptitud;
    }

    public String getNombreAptitud() {
        return nombreAptitud;
    }

    public void setNombreAptitud(String nombreAptitud) {
        this.nombreAptitud = nombreAptitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aptitud(String idAptitud, String nombreAptitud, String descripcion) {
        this.idAptitud = idAptitud;
        this.nombreAptitud = nombreAptitud;
        this.descripcion = descripcion;
    }
}