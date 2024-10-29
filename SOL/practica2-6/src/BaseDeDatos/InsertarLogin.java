/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import static BaseDeDatos.Conection.conexionDatos;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enri
 */
public class InsertarLogin {

    public static void insertarUsuarios(Usuarios usua) {

        try {
            Connection con = conexionDatos();
            String myQueryPrepared = "INSERT INTO usuario(usuario,contraseña,nombre,apellido,fechaN,correo) VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = con.prepareStatement(myQueryPrepared);
            ps.setString(1, usua.getUsuario());
            ps.setString(2, usua.getContraseña());
            ps.setString(3, usua.getNombre());
            ps.setString(4, usua.getApellidos());
            ps.setString(5, usua.getFechaNacimiento());
            ps.setString(6, usua.getCorreo());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error, ya existe el usuario");
            e.printStackTrace();
        }
    }

    public static boolean existeUsuario(String usuario, String contraseña) {

        boolean existe = false;

        try {
            Connection con = conexionDatos();
            String myQueryPrepared = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?;";

            PreparedStatement ps = con.prepareStatement(myQueryPrepared);

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            existe = rs.next();
            return existe;

        } catch (SQLException e) {
            System.out.println("Error, No existe el usuario");
            e.printStackTrace();
        }
        return existe;
    }

    public static boolean verificarUsuarioDuplicado(String usuario) {

        try {
            Connection con = conexionDatos();
            String query = "SELECT COUNT(*) FROM usuario WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error, Ya existe el usuario");
            e.printStackTrace();

        }
        return false;
    }

    public static boolean cambiarContraseña(String usuario, String contraseña) {

        try {
            Connection con = conexionDatos();
            String myQueryPrepared = "UPDATE usuario set contraseña=? where usuario=?;";

            PreparedStatement ps = con.prepareStatement(myQueryPrepared);

            ps.setString(1, contraseña);
            ps.setString(2, usuario);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        return false;
    }

}
