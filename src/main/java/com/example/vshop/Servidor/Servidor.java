package com.example.vshop.Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.example.vshop.Cliente.Cliente;;

public class Servidor extends Thread{
    Socket skCliente;
    static final int PUERTO = 1234;
    static GestionServidor gestionServidor = new GestionServidor();

    public Servidor(Socket skCliente) throws IOException {
        this.skCliente = skCliente;
    }

    static ArrayList<Cliente> clientesConectados = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket skServidor = new ServerSocket(PUERTO)){
            System.out.println("El servidor está encendido");
            System.out.println(GestionServidor.baseDeDatos.isConnected());

            while (true){
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                new Servidor(skCliente).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("Atendiendo al cliente");
        try {


            if(gestionServidor.logIn(skCliente)){

                DataInputStream datosEntrada = new DataInputStream(skCliente.getInputStream());

                while (skCliente.isConnected()){
                    String datoRecibido = datosEntrada.readUTF();
                    System.out.println("datoRecibido = " + datoRecibido);
                }

            }else{
                System.out.println("No se ha podido conectar con el cliente");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
