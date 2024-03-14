package com.example.vshop.GestionContenido;

public class LenguajeProgramacion {
    private String idLenguajeProgramacion;
    private String nombreLenguajeProgramacion;

    public LenguajeProgramacion(String idLenguajeProgramacion, String nombreLenguajeProgramacion) {
        this.idLenguajeProgramacion = idLenguajeProgramacion;
        this.nombreLenguajeProgramacion = nombreLenguajeProgramacion;
    }

    public LenguajeProgramacion() {
    }

    public String getIdLenguajeProgramacion() {
        return idLenguajeProgramacion;
    }

    public void setIdLenguajeProgramacion(String idLenguajeProgramacion) {
        this.idLenguajeProgramacion = idLenguajeProgramacion;
    }

    public String getNombreLenguajeProgramacion() {
        return nombreLenguajeProgramacion;
    }

    public void setNombreLenguajeProgramacion(String nombreLenguajeProgramacion) {
        this.nombreLenguajeProgramacion = nombreLenguajeProgramacion;
    }
}
