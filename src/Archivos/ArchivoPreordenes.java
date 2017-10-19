/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Herencia.Preorden;
import static Interfaces.AñadirPelicula.nombrepeli;
import static Interfaces.Usuario.usunombre;
import Procedimientos.Instancias;
import static Procedimientos.Usuariocomdisco.correouser;
import static Procedimientos.Usuariocomdisco.usuario;
import static Procedimientos.procedimientodisco.nombre;
import static Procedimientos.procedimientodisco.preorden;
import static Procedimientos.procedimientopeli.nombrepeli2;
import static Procedimientos.procedimientopeli.preordenpeli;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ArchivoPreordenes {

    String tipodisco = "Disco";
    String tipopeli = "Pelicula";
    
    Instancias insta = new Instancias();
    public String obtenercorreo(){
        String correo = null;
        try {
            String temp;

            BufferedReader bf = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(usunombre.getText())) {
                    correo = lista1[3];
                }

            }
            bf.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
    
    return correo;}

    public void AnadirPreordendisco() {
        Preorden orden = new Preorden(usuario,nombre,tipodisco,preorden, obtenercorreo());
        try {
            

            try {
                BufferedWriter bw;

                bw = new BufferedWriter(new FileWriter("Pre-Ordenes.txt", true));
                bw.write(orden.devolver()+"\n");

                bw.close();
            } catch (IOException ex) {

            }
            JOptionPane.showMessageDialog(null, "Se ha Registrado la Pre-Orden Correctamente!");
            
        } catch (java.lang.NumberFormatException e) {
            
        }

    }
    public void AnadirPreordenpelicula() {
        
        try {
            

            try {
                BufferedWriter bw;

                bw = new BufferedWriter(new FileWriter("Pre-Ordenes.txt", true));
                bw.write(usuario + ";" + nombrepeli2 + ";" + tipopeli + ";" + preordenpeli +";" + obtenercorreo() +"\n");

                bw.close();
            } catch (IOException ex) {

            }
            JOptionPane.showMessageDialog(null, "Se ha Registrado la Pre-Orden Correctamente!");
            
        } catch (java.lang.NumberFormatException e) {
            
        }

    }
}
