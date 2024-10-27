/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.sql.*;

/**
 *
 * @author Enri
 */
public class Conection {

    private static Connection con = null;

    public static Connection conexionDatos() {

        if (con == null) {
            String cadena = "jdbc:mysql://localhost:3306/";
            String bd = "Usuarios";
            String usuario = "root";
            String contraseña = null;

            try {

                con = DriverManager.getConnection(cadena + bd, usuario, contraseña);

            } catch (SQLException e) {
                System.out.println("Error, no se puede conectar");
                
            }

        }
        return con;

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
