package com.example.vshop.Servidor;

import com.example.vshop.GestionContenido.Idioma;
import com.example.vshop.GestionContenido.Ropa;
import com.example.vshop.GestionContenido.Tienda;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {

    // Declaracion de variables de la database
    private static final String nameDatabase ="Vshop";
    private static final String userDatabase ="Vshop";
    private static final String passwordDatabase ="Vshop";

    // Declaracion de variables de clases
    Ropa gestionRopa = new Ropa();
    Tienda gestionTienda = new Tienda();

    public boolean isConnected(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameDatabase, userDatabase, passwordDatabase);
            return true; // si no hay excepcion de la conexion significa que se conecta
        }catch (Exception e){
            return false;
        }
    }


    public boolean logIn(String username, String password) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameDatabase, userDatabase, passwordDatabase);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Usuarios WHERE nombreUsuario  = '" + username + "' AND contrasenaUsuario = '" + password +"'"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println("Usuario conectado correctamente");
                return true;
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
    }

    public boolean filtrarEstiloTienda(String estiloTienda) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameDatabase, userDatabase, passwordDatabase);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Usuarios WHERE nombreUsuario  = '" + username + "' AND contrasenaUsuario = '" + password +"'"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println("Usuario conectado correctamente");
                return true;
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> obtenerIdiomasUsuario (String nombreUsuario){
        ArrayList<String> idiomasHablado = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameDatabase, userDatabase, passwordDatabase);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT idiomas.nombreIdioma FROM usuarios INNER JOIN conocimientosUsuario ON usuarios."
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String idioma = resultSet.getString("nombreIdioma");
                idiomasHablado.add(idioma); // se añade un idioma por cada registro de idiomas hablado por el usuario
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return idiomasHablado;
    }

    public ArrayList<String> obtenerLenguajeProgramacionUsuario (String nombreUsuario){
        ArrayList<String> lenguajeProgramacionConocidos = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameDatabase, userDatabase, passwordDatabase);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT lenguajeProgramacion.nombreLenguajeProgramacion FROM usuarios INNER JOIN conocimientosUsuario ON usuarios."
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String lenguaje = resultSet.getString("nombreLenguajeProgramacion");
                lenguajeProgramacionConocidos.add(lenguaje); // se añade un idioma por cada registro de idiomas hablado por el usuario
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return lenguajeProgramacionConocidos;
    }

}