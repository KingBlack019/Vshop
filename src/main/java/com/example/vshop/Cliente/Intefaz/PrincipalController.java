package com.example.vshop.Cliente.Intefaz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.Socket;

public class PrincipalController {
    @FXML
    private Label userLogged;


    @FXML
    protected void onButtonClick() throws IOException {
        Configuracion.ConfigDialog(skCliente);
    }

    // Método para establecer el nombre de usuario
    public void setUser(String username) {
        userLogged.setText("User: " + username);
    }

    Socket skCliente;
    public void setSocketUser(Socket skCliente) {
        this.skCliente = skCliente;
    }
}