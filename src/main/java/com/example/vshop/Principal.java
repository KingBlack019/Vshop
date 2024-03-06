package com.example.vshop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal {

    public static void panelPrincipal(String username, String password) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("Principal.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Accede al controlador del archivo FXML
        PrincipalController controller = fxmlLoader.getController();

        controller.setUser(username);

        // Crear la ventana y establecer la escena
        Stage stage = new Stage();
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }


}
