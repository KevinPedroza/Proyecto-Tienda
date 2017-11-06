/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class UsuarioRegister extends ClasePersona {
//this method will have all the variables used to save information on the file as herency

    public UsuarioRegister(String Nombre, String Cedula, String Contraseña, String Correo) {
        super(Nombre, Cedula, Contraseña, Correo);
    }

    public String register() {

        return Nombre + ";" + Cedula + ";" + Contraseña + ";" + Correo;
    }

}
