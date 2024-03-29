package com.example.vshop.Cliente.Intefaz;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Principal {

    Socket skCliente;
    public Principal(Socket socketClienteObtenido) {
        this.skCliente = socketClienteObtenido;
    }

    public void panelPrincipal(String username) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("/com/example/vshop/Principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 620);

        // Accede al controlador del archivo FXML
        PrincipalController controller = fxmlLoader.getController();
        controller.setSocketUser(skCliente);
        controller.setUser(username);

        // Crear la ventana y establecer la escena
        Stage stage = new Stage();
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }
}