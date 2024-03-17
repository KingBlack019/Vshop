package com.example.vshop.Cliente.Intefaz;

import com.example.vshop.GestionContenido.ClaveDatos;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConfiguracionController {


    public void setCliente(Socket skCliente, String username){

        try {
            DataInputStream dis = new DataInputStream(skCliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(skCliente.getOutputStream());

            System.out.println("ClaveDatos.VERMISDATOS.toString() = " + ClaveDatos.VERMISDATOS.toString());
            enviarString(dos, ClaveDatos.VERMISDATOS.toString()); // ENVIAR STRING 1 VERMISDATOS
            enviarString(dos, username); // ENVIAR STRING 2 USERNAME


            // GET STRINGS FROM THE SERVER WHICH IS USER INFO
            leerString(dis); // RECIBIR STRING 1 - NOMBRE
            String cargoEmpresa = leerString(dis); // RECIBIR STRING 2 - CARGO EMPRESA
            String fechaNacimiento = leerString(dis); // RECIBIR STRING 3 - FECHA DE NACIMIENTO
            String correoElectronico = leerString(dis); // RECIBIR STRING 4 - CORREO ELECTRONICO

            // SET THOSE STRINGS IN THE LABELS
            setUsername(username);
            setlabelCargo(cargoEmpresa);
            setlabelCorreo(correoElectronico);
            setFechaNac(fechaNacimiento);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String leerString(DataInputStream dis) throws IOException {
        return dis.readUTF();
    }
    public static void enviarString(DataOutputStream dos, String texto) throws IOException {
        dos.writeUTF(texto);
    }

    @FXML
    private Label labelUsername;

    @FXML
    private Label labelFechaNac;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelCargo;

    public void setUsername(String username) {
        labelUsername.setText(username);
    }

    public void setFechaNac(String fechaNac) {
        labelFechaNac.setText(fechaNac);
    }

    public void setlabelCorreo(String correo) {
        labelCorreo.setText(correo);
    }

    public void setlabelCargo(String cargo) {
        labelCargo.setText(cargo);
    }



}
