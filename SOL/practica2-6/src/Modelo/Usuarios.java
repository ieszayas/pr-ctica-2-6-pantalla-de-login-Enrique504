/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author DAM2_11
 */
public class Usuarios {

    private String[] usuarios = {"Carlos"};
    private String[] contraseñas = {"pass1"};

    public boolean validarUsuario(String nombreUsuario, String contraseña) {

        for (int i = 0; i < usuarios.length; i++) {

            if (usuarios[i].equals(nombreUsuario) && contraseñas[i].equals(contraseña)) {
                return true;
            }
        }

        return false;
    }

}
