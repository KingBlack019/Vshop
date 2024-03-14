package com.example.vshop.GestionContenido;

public class Ropa {
    private String idRopa;
    private String nombreRopa;
    private String textura;
    private double precio;
    private String idTalla;
    private String idEstilo;

    public Ropa(String idRopa, String nombreRopa, String textura, double precio, String idTalla, String idEstilo) {
        this.idRopa = idRopa;
        this.nombreRopa = nombreRopa;
        this.textura = textura;
        this.precio = precio;
        this.idTalla = idTalla;
        this.idEstilo = idEstilo;
    }

    public Ropa() {
    }

    public String getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(String idRopa) {
        this.idRopa = idRopa;
    }

    public String getNombreRopa() {
        return nombreRopa;
    }

    public void setNombreRopa(String nombreRopa) {
        this.nombreRopa = nombreRopa;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public String getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(String idTalla) {
        this.idTalla = idTalla;
    }

    public String getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(String idEstilo) {
        this.idEstilo = idEstilo;
    }
}
