/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class login {

    public void crearlogin() {
        //this method will create the login of the admi
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("Administrador.txt"));
            bw.write("Kevin,kevin23");

            bw.close();
        } catch (IOException ex) {
            System.out.println("No se Encontro el archivo" + ex);
        }

    }

    public String obtener() {
        //this method will the information about the admi
        String lista = null;
        try {
            String temp;

            BufferedReader bf = new BufferedReader(new FileReader("Administrador.txt"));

            temp = "";
            String bfRead = bf.readLine();

            temp = bfRead;
            lista = temp;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
        }

        return lista;
    }

   

}
