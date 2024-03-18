package com.example.vshop.Servidor;

import com.example.vshop.Cliente.Cliente;
import com.example.vshop.GestionContenido.*;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {

    // Declaracion de variables de la database
    private static final String nameDatabase ="vshop";
    private static final String userDatabase ="vshop";
    private static final String passwordDatabase ="vshop";

    // Declaracion de variables de clases
    Ropa gestionRopa = new Ropa();
    Tienda gestionTienda = new Tienda();

    public boolean isConnected(){
        try{
            getConnection();
            return true; // si no hay excepcion de la conexion significa que se conecta
        }catch (Exception e){
            return false;
        }
    }

// TODO BASE DE DATOS LOGIN
    public boolean logIn(String username, String password) {
        try{
            Connection connection = getConnection();
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
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT ropa.nombre FROM tienda INNER JOIN tipo ON tienda. "
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

        try{
            Connection connection = getConnection();
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

        try{
            Connection connection = getConnection();
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameDatabase, userDatabase, passwordDatabase);
    }

    public Cliente obtenerDatosUsuario(String username) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM usuarios WHERE usuarios.nombreUsuario = '" + username + "' "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String nombreUsuario = resultSet.getString("nombreUsuario");
                String cargoEmpresa = resultSet.getString("cargoEmpresa");
                String fechaNacimiento = resultSet.getString("fechaNacimiento");
                String correoElectronico = resultSet.getString("correoElectronico");


                return new Cliente(nombreUsuario, cargoEmpresa, fechaNacimiento, correoElectronico);
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return null;
    }

    public Tienda obtenerTienda(String nombreTienda) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tiendas WHERE tiendas.idTienda = '" + nombreTienda + "' "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String idTienda = resultSet.getString("idTienda");
                String descripcion = resultSet.getString("descripcion");
                String direccion = resultSet.getString("direccion");
                String idEstilo = resultSet.getString("idEstilo");
                String nombreEstiloTienda = getNombreEstiloTienda(idEstilo);


                return new Tienda(idTienda, nombreTienda, descripcion, direccion, new Estilo(idEstilo, nombreEstiloTienda));
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return null;

    }

    private String getNombreEstiloTienda(String idEstilo) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM estiloTienda WHERE estiloTienda.idEstilo = '" + idEstilo + "' "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("nombreEstilo");
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return null;
    }

    // TODO OBSERVAR EL COMPORTAMIENTO DEL LENGUAJE DEL USUARIO PARA OBSERVAR SI FUNCIONA CORRECTAMENTE
    // - HAY QUE INSERTAR TANTO LOS LENGUAJES A LA BASE DE DATOS COMO LA UNION CON RESPECTIVOS USUARIOS

    public ArrayList<LenguajeProgramacion> getListaLenguajesUsuario(String nombreUsuario){
        ArrayList<LenguajeProgramacion> lenguajes = null;
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM usuarios INNER JOIN conocimientosUsuario ON usuarios.nombreUsuario = conocimientosUsuario.nombreUsuario" +
                            "WHERE usuarios.nombreUsuario = '" + nombreUsuario + "' "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                // si el tipo de conociemiento del usuario coincide con un lenguaje pues lo extrae para añadirlo al arraylist
                if (resultSet.getString("tipoConocimiento").toUpperCase().equals(TipoConocimiento.LENGUAJE.toString())){
                    LenguajeProgramacion lp = getLenguajeProgramacion(resultSet.getString("claveConocimiento"));
                    if( lp != null ){
                        lenguajes.add(lp);
                    }
                }
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        return lenguajes;
    }

    private LenguajeProgramacion getLenguajeProgramacion(String claveConocimiento) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM lenguajesProgramacion WHERE lenguajesProgramacion.idLenguajeProgramacion = '" + claveConocimiento + "' "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               return new LenguajeProgramacion(claveConocimiento, resultSet.getString("nombreLenguajeProgramacion"));
            }

        }catch (Exception e ){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return null;
    }

}

enum TipoConocimiento{
    LENGUAJE,
    APTITUD,
    IDIOMA
}