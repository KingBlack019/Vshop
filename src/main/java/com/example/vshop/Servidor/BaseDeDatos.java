package com.example.vshop.Servidor;

import java.sql.*;

public class BaseDeDatos {
    private static final String nameDatabase ="Vshop";
    private static final String userDatabase ="Vshop";
    private static final String passwordDatabase ="Vshop";

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
                System.out.println("El usuario no existe");
                return false;
            }
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
    }
}
