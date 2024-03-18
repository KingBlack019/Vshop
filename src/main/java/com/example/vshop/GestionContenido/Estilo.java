package com.example.vshop.GestionContenido;

public class Estilo {
    private String idEstilo;
    private String nombreEstilo;

    public Estilo(String idEstilo, String nombreEstilo) {
        this.idEstilo = idEstilo;
        this.nombreEstilo = nombreEstilo;
    }

    public String getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(String idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombreEstilo() {
        return nombreEstilo;
    }

    public void setNombreEstilo(String nombreEstilo) {
        this.nombreEstilo = nombreEstilo;
    }
}
