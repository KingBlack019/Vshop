package com.example.vshop.GestionContenido;

public class ConocimientosUsuario {
    private String nombreUsuario;
    private String claveConocimiento;
    private TipoConocimiento tipoConocimiento;



    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveConocimiento() {
        return claveConocimiento;
    }

    public void setClaveConocimiento(String claveConocimiento) {
        this.claveConocimiento = claveConocimiento;
    }

    public TipoConocimiento getTipoConocimiento() {
        return tipoConocimiento;
    }

    public void setTipoConocimiento(TipoConocimiento tipoConocimiento) {
        this.tipoConocimiento = tipoConocimiento;
    }

    public ConocimientosUsuario(String nombreUsuario, String claveConocimiento, TipoConocimiento tipoConocimiento) {
        this.nombreUsuario = nombreUsuario;
        this.claveConocimiento = claveConocimiento;
        this.tipoConocimiento = tipoConocimiento;
    }
}

enum TipoConocimiento{
    LENGUAJE,
    IDIOMA,
    APTITUD
}