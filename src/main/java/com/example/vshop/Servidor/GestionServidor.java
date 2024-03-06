package com.example.vshop.Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestionServidor {

    static BaseDeDatos baseDeDatos = new BaseDeDatos();

    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    public void logIn(Socket skCliente) {
        try {
            flujoEntrada = new DataInputStream(skCliente.getInputStream());
            flujoSalida = new DataOutputStream(skCliente.getOutputStream());

            // recibe el username y la contraseña
            String username = flujoEntrada.readUTF(); // leer String 1
            String password = flujoEntrada.readUTF(); // leer String 2

            baseDeDatos.logIn(username, password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void escribirEntero(int num){
        try {
            flujoSalida.writeInt(num);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void escribirTexto(String texto){
        try {
            flujoSalida.writeUTF(texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
