package com.example.vshop.Cliente.Intefaz;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Configuracion {

    public static void ConfigDialog() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("/com/example/vshop/Configuracion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Crear la ventana y establecer la escena
        Stage stage = new Stage();
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }
}
