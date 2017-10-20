/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.ArchivoPreordenes;
import static Interfaces.CompraDisco.jlistacompradisco;
import static Interfaces.EliminarDisco.Jeliminar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static Interfaces.ProcesoCompraDisco.totallabel;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class procedimientodisco extends JFrame {

    public static String preorden;
    public static String nombre;
    ArchivoPreordenes pre = new ArchivoPreordenes();
    Instancias insta = new Instancias();

    public void leercantidad() {
        String canti = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistacompradisco.getSelectedValue().equals(lista1[0])) {
                    canti = lista1[5];
                    nombre = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
       
        if (Integer.parseInt(canti) <= 0) {

            Object preg = "No Disponemos de este Disco" + "\n"
                    + "Desea Realizar una Pre-Orden?";
            Object unComponentePadre = null;
            Object unIcono = null;
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Aceptar", "Cancelar"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 0) {
                preorden = JOptionPane.showInputDialog("Ingrese la Cantidad que Desea");
                this.setVisible(false);
                pre.AnadirPreordendisco();
                insta.compradisco();
            } else {
                insta.compradisco();
            }

        }
    }

    public void obtenerprecio(int cantidad) {
        String can = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistacompradisco.getSelectedValue().equals(lista1[0])) {
                    can = lista1[4];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        int cantint = Integer.parseInt(can);
        int total = cantidad * cantint;
        totallabel.setText("₡" + String.valueOf(total));

    }

}
