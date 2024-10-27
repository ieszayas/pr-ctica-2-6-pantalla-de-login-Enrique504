/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import BaseDeDatos.Conection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM2_11
 */
public class Usuarios {

//    private String[] usuarios = {"Carlos","Pablo"};
//    private String[] contraseñas = {"pass1","pass2"};
    public static void registrarUsuario(String nombreUsuario, String contraseña) {

        try {

            Connection con = Conection.conexionDatos();

            String myQueryPrepared = "INSERT INTO usuario(usuario,contraseña) VALUES(?,?);";
            PreparedStatement ps = con.prepareStatement(myQueryPrepared);

            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario es correcto");
        } catch (SQLException e) {
            System.out.println("Error, ya existe el usuario");
            e.printStackTrace();
        }

    }

}

//        for (int i = 0; i < usuarios.length; i++) {
//
//            if (usuarios[i].equals(nombreUsuario) && contraseñas[i].equals(contraseña)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

