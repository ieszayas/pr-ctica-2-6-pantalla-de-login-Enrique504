/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Enri
 */
public class Conection {

    private static Connection con = null;
    
    public static Connection conexionDatos() {

        if (con == null) {

            try {
                File archivo = new File("src/ficheroConfiguracion/config.properties");
                if (archivo.exists()) {
                    String fichero[] = leerFichero(archivo);
                    String usuario = fichero[0];
                    String contraseña = fichero[1];
                    String cadena = fichero[2];
                    String bd = fichero[3];

                    con = DriverManager.getConnection(cadena + bd, usuario, contraseña);
                    System.out.println("conecion exitosa");

                }
            } catch (SQLException e) {
                System.out.println("Error");

            }

        }
        return con;
    }

//    public static Connection conexionDatos() {
//
//        if (con == null) {
//            String cadena = "jdbc:mysql://localhost:3306/";
//            String bd = "Usuarios";
//            String usuario = "root";
//            String contraseña = null;
//
//            try {
//
//                con = DriverManager.getConnection(cadena + bd, usuario, contraseña);
//
//            } catch (SQLException e) {
//                System.out.println("Error, no se puede conectar");
//                
//            }
//
//        }
//        return con;
//
//    }
    public static String[] leerFichero(File archivo) {
        Properties propiedad = new Properties();

        try (FileInputStream input = new FileInputStream(archivo)) {
            propiedad.load(input);
            String usuario = propiedad.getProperty("usuario");
            String contraseña = propiedad.getProperty("contraseña");
            String cadena = propiedad.getProperty("cadena");
            String nombreBaseDatos = propiedad.getProperty("bd");

            String arr[] = {usuario, contraseña, cadena, nombreBaseDatos};
            return arr;
        } catch (IOException e) {
            System.out.println("Error en el archivo: " + e.getMessage());
        }
        return new String[]{"Error al cargar el archivo"};
    }

    public static void cerrarConexion() {

        if (con != null) {
            try {
                con.close();
                System.out.println("Conexion se ha cerrada correctamente");
            } catch (SQLException e) {
                System.out.println("Error al intentar cerrar la conexion " + e.getMessage());
            }
        } else {
            System.out.println("No tienes una conexion para intentar cerrar");
        }
    }
   

}
