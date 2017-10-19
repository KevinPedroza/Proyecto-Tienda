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
public class Preorden {

    String Usuario;
    String Nombre;
    String TipoDisco;
    String PreOrden;
    String Correo;

    public Preorden(String Usuario, String Nombre, String TipoDisco, String PreOrden, String Correo) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.TipoDisco = TipoDisco;
        this.PreOrden = PreOrden;
        this.Correo = Correo;
    }

    public String devolver() {
        return Usuario + ";" + Nombre + ";" + TipoDisco + ";" + PreOrden + ";" + Correo;
    }
}
