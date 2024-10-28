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

    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String correo;

    public Usuarios(String usuario, String contraseña, String nombre, String apellidos, String fechaNacimiento, String correo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }
    //    public static void registrarUsuario(String nombreUsuario, String contraseña) {
//        
//        
//        try {
//
//            Connection con = Conection.conexionDatos();
//
//            String myQueryPrepared = "INSERT INTO usuario(usuario,contraseña) VALUES(?,?);";
//            PreparedStatement ps = con.prepareStatement(myQueryPrepared);
//
//            ps.setString(1, nombreUsuario);
//            ps.setString(2, contraseña);
//
//            ps.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "El usuario es correcto");
//        } catch (SQLException e) {
//            System.out.println("Error, ya existe el usuario");
//            e.printStackTrace();
//        }
//
//    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
