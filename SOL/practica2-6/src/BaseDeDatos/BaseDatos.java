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
public class BaseDatos {

    private static Connection con = null;

    public static void conexionBaseDeDatos() {

        if (con == null) {
            String cadena = "jdbc:mysql://localhost:3306/";
            String bd = "Usuarios";
            String usuario = "root";
            String contraseña = null;

            try {
                con = DriverManager.getConnection(cadena, usuario, contraseña);
                String myQueryPrepared = "CREATE DATABASE IF NOT EXISTS " + bd;
                PreparedStatement ps = con.prepareStatement(myQueryPrepared);
                ps.executeUpdate();//ejecuta la consulta que ya fue preparada

                ps.executeUpdate("USE " + bd);

                String crearTabla = "CREATE TABLE IF NOT EXISTS usuario(\n"
                        + "    id integer AUTO_INCREMENT ,\n"
                        + "    usuario varchar(25) ,\n"
                        + "    contraseña varchar(20) NOT NULL,\n"
                        + "    nombre varchar(20),\n"
                        + "    apellido varchar(30),\n"
                        + "    fechaN varchar(30),\n"
                        + "    correo varchar(30),\n"
                        + "    PRIMARY KEY(id,usuario)\n"
                        + "    );";

                ps.executeUpdate(crearTabla);

            } catch (SQLException e) {
                System.out.println("Error");

            }

        }

    }

}
