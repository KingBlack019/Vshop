package com.example.vshop.GestionContenido;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestionDatos {
    /*
    Devuelve los datos que exige el usuario, en este caso al entrar a configuración se vera los datos
     */

    public void verMisDatos(Socket skCliente) {
        try {
            DataInputStream dis = new DataInputStream(skCliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(skCliente.getOutputStream());

            System.out.println("ClaveDatos.VERMISDATOS.toString() = " + ClaveDatos.VERMISDATOS.toString());
            dos.writeUTF(ClaveDatos.VERMISDATOS.toString());

            leerString(dis); // RECIBIR STRING 1 - NOMBRE
            leerString(dis); // RECIBIR STRING 2 - APELLIDO
            leerString(dis); // RECIBIR STRING 3 - FECHA DE NACIMIENTO


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String leerString(DataInputStream dis) throws IOException {
        return dis.readUTF();
    }
}
