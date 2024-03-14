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
    private String contraseña;
    private Date fechaNacimiento;
    private String correoElectronico;

    static LogIn login = new LogIn();

    public static void main(String[] args) {
        try {
            Socket skCliente = new Socket("localhost", 1234);
            LogIn.execute(skCliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}