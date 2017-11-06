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
public class ClasePersona {

    //this is the father class where the others son classes get the principal variables
    String Nombre;
    String Cedula;
    String Contraseña;
    String Correo;

    public ClasePersona(String Nombre, String Cedula, String Contraseña, String Correo) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Contraseña = Contraseña;
        this.Correo = Correo;
    }
}
