package com.example.vshop.Servidor;

import com.example.vshop.Cliente.Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GestionServidor {

    static BaseDeDatos baseDeDatos = new BaseDeDatos();

    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    ServerSocket skServidor;

    public GestionServidor(ServerSocket skServidor) {
        this.skServidor = skServidor;
    }



    public boolean logIn(Socket skCliente) {
        try {
            flujoEntrada = new DataInputStream(skCliente.getInputStream());

            // recibe el username y la contraseña
            String username = flujoEntrada.readUTF(); // leer String 1
            String password = flujoEntrada.readUTF(); // leer String 2

            System.out.println("username = " + username);
            System.out.println("password = " + password);

            if (baseDeDatos.logIn(username.trim(), password.trim())){
                flujoSalida = new DataOutputStream(skCliente.getOutputStream());
                flujoSalida.writeBoolean(true);
                return true;
            }

            return false;
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



    public void verDatosUsuario() throws IOException {
        System.out.println(" Ver datos usuario gestion servidor ");

        Cliente datosUsuario = baseDeDatos.obtenerDatosUsuario(flujoEntrada.readUTF());

        System.out.println("datosUsuario = " + datosUsuario.getNombre());
        System.out.println("datosUsuario = " + datosUsuario.getCargoEmpresa());
        System.out.println("datosUsuario = " + datosUsuario.getFechaNacimiento());
        System.out.println("datosUsuario = " + datosUsuario.getCorreoElectronico());


        escribirTexto(datosUsuario.getNombre());
        escribirTexto(datosUsuario.getCargoEmpresa());
        escribirTexto(datosUsuario.getFechaNacimiento());
        escribirTexto(datosUsuario.getCorreoElectronico());

    }
}
