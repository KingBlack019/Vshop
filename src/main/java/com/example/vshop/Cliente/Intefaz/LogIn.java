package com.example.vshop.Cliente.Intefaz;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class LogIn extends Application {

    private static Stage stageLogIn;
    FXMLLoader fxmlLoader = new FXMLLoader(LogIn.class.getResource("/com/example/vshop/LogIn.fxml"));

    private static Socket socketClienteObtenido;

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(fxmlLoader.load(), 420, 340);

        stage.setTitle("Inicio Sesion");
        stage.setScene(scene);
        stage.show();
        stageLogIn = stage;
    }

    public static void execute(Socket skCliente) {
        socketClienteObtenido = skCliente;
        launch();
    }

    @FXML
    protected void onButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Principal.panelPrincipal(username, password);

        DataOutputStream datosSalida = new DataOutputStream(socketClienteObtenido.getOutputStream());

        datosSalida.writeUTF(username);
        datosSalida.writeUTF(password);

        // Close login window
        stageLogIn.close();
    }

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
}