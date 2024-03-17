package com.example.vshop.Cliente.Intefaz;

import com.example.vshop.GestionContenido.GestionDatos;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Configuracion {

    // TODO METER LOS DATOS DEL USUARIO INGRESAD
    public static void ConfigDialog(Socket skCliente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("/com/example/vshop/Configuracion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 500);

        ConfiguracionController controller = fxmlLoader.getController();

        // Crear la ventana y establecer la escena
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        // Mostrar la ventana
        stage.show();


    }

}
