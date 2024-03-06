package com.example.vshop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class PrincipalController {
    @FXML
    private Label userLogged;

    @FXML
    protected void onButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = usernameField.getText();

        Principal.panelPrincipal(username, password);

        // Close login window
        stageLogIn.close();
    }

    // Método para establecer el nombre de usuario
    public void setUser(String username) {
        userLogged.setText("User: " + username);
    }
}
