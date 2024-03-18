package com.example.vshop.Cliente;

import com.example.vshop.Cliente.Intefaz.LogIn;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Cliente {
    private String nombre;
    private String contrasena;
    private String fechaNacimiento;
    private String correoElectronico;
    private String cargoEmpresa;


    static LogIn login = new LogIn();

    public Cliente(String nombre, String cargoEmpresa, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.cargoEmpresa= cargoEmpresa;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }

    public static void main(String[] args) {
        try {
            Socket skCliente = new Socket("localhost", 1234);
            LogIn.execute(skCliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", cargoEmpresa='" + cargoEmpresa + '\'' +
                '}';
    }
}