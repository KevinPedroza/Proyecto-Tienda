/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.ArchivoPreordenes;
import static Interfaces.CompraPelicula.jlistapelicula;
import static Interfaces.ProcesoCompraPelicula.totalpeli;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class procedimientopeli extends JFrame {

    Instancias insta = new Instancias();

    public static String preordenpeli;
    public static String nombrepeli2;
    ArchivoPreordenes pre = new ArchivoPreordenes();

    public void leercantidad() {
        String cantipeli = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistapelicula.getSelectedValue().equals(lista1[0])) {
                    cantipeli = lista1[4];
                    nombrepeli2 = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        
        if (cantipeli.equals("0")) {

            Object preg = "No disponemos de este producto por el momento \n"
                    + "Desea Realizar una Pre-Orden?";
            Object unComponentePadre = null;
            Object unIcono = null;
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Aceptar", "Cancelar"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 0) {
                preordenpeli = JOptionPane.showInputDialog("Ingrese la Cantidad que Desea");
                this.setVisible(false);
                pre.AnadirPreordenpelicula();
                insta.comprapelicula();

            } else {
                insta.comprapelicula();
            }

        }
    }

    public void obtenerprecio(int cantidad) {
        String can = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistapelicula.getSelectedValue().equals(lista1[0])) {
                    can = lista1[3];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        int cantint = Integer.parseInt(can);
        int total = cantidad * cantint;
        totalpeli.setText("₡" + String.valueOf(total));

    }

}
