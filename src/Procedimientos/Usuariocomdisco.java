/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.ArchivosDiscos;
import Archivos.ArchivoUsuario;
import static Interfaces.CompraDisco.buscarautor;
import static Interfaces.CompraDisco.buscarnombre;
import static Interfaces.CompraDisco.buscarprecio;
import static Interfaces.CompraDisco.buscarprecio2;
import static Interfaces.CompraDisco.jlistacompradisco;
import static Interfaces.CompraDisco.jtablecompradisco;
import static Interfaces.CompraDisco.modelo;
import static Interfaces.LeerDisco.Jtable;
import Interfaces.Usuario;
import static Interfaces.Usuario.usucontra;
import static Interfaces.Usuario.usunombre;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.applet.AudioClip;

/**
 *
 * @author Kevin
 */
public class Usuariocomdisco extends JFrame {

    AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Martin Garrix Bebe Rexha - In The Name Of Love (Official Video) (online-audio-converter.com).wav"));
    AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Martin Garrix Dua Lipa - Scared To Be Lonely (Official Video) (online-audio-converter.com).wav"));
    AudioClip sonido3 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/P!nk - What About Us (Shaun Barron Bootleg) (online-audio-converter.com).wav"));
    AudioClip sonido4 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Jason Derulo - Swalla (feat. Nicki Minaj Ty Dolla $ign) (Official Music Video) (online-audio-converter.com).wav"));
    AudioClip sonido5 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/La Tierra Canta - Barak (letra)_3P6KiEY_zA0_youtube (online-audio-converter.com).wav"));

    public String[] leer() {
        ArchivoUsuario lo = new ArchivoUsuario();
        lo.crearlogin();
        String info = lo.obtener();

        String[] posi = info.split(";");

        return posi;
    }

    public static void crear() {
        ArchivoUsuario lo = new ArchivoUsuario();
        lo.crearlogin();
    }

    public static boolean vacio() {
        boolean vacio = false;

        try {
            FileReader fr = new FileReader("Usuarios.txt");
            BufferedReader bf = new BufferedReader(fr);

            String sCadena = "";
            while ((sCadena = bf.readLine()) != null) {
                vacio = true;

            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivosDiscos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacio;

    }

    public void ingreusu() {

        if (vacio() == true) {
            try {
                String[] info = leer();

                String usu = info[0];
                String contra = info[2];
                String u = usunombre.getText();
                String c = usucontra.getText();
                if (u.equals(usu) & c.equals(contra)) {
                    JOptionPane.showMessageDialog(null, "Login Correcto!");
                    Instancias insta = new Instancias();
                    insta.modocompra();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña o Usuario Incorrecto!");
                    usunombre.setText("");
                    usucontra.setText("");
                    new Usuario(this, true).setVisible(true);
                }
            } catch (java.lang.NullPointerException e) {

            }

        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra en el Sistema o datos Incorrectos!");
            usunombre.setText("");
            usucontra.setText("");
            new Usuario(this, true).setVisible(true);
        }
    }

    public void Cargarnombre() {
        String buscarname = buscarnombre.getText();
        String busautor = buscarautor.getText();
        String busprecio = buscarprecio.getText();
        String busprecio2 = buscarprecio2.getText();
        int precio1 = 0;
        int precio2 = 0;
        boolean vacio = false;
        if (buscarnombre.getText().equals("") & buscarautor.getText().equals("") & buscarprecio.getText().equals("") & buscarprecio2.getText().equals("")) {
            vacio = true;
            JOptionPane.showMessageDialog(null, "Ingrese algún Parametro de busqueda!");

        }
        if (vacio == false) {
            modelo.clear();

            try {
                precio1 = Integer.parseInt(busprecio);
                precio2 = Integer.parseInt(busprecio2);
            } catch (java.lang.NumberFormatException e) {
            }
            boolean existe = false;
            String nombre = null;
            try {
                String temp;
                BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

                temp = "";
                String bfRead;
                while ((bfRead = bf2.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;

                    String[] lista1 = lista.split(";");

                    if (lista1[0].equalsIgnoreCase(buscarname) || lista1[1].equalsIgnoreCase(busautor) || (Integer.parseInt(lista1[4]) <= precio2 & Integer.parseInt(lista1[4]) >= precio1)) {

                        modelo.addElement(lista1[0]);
                        existe = true;

                    }

                }

                bf2.close();

            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
        }

    }

    public void mostrarinfor() {

        String nombre = jlistacompradisco.getSelectedValue();

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> lista2 = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();

        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Discos.txt");
            BufferedReader bf = new BufferedReader(fr);

            String sCadena = "";
            while ((sCadena = bf.readLine()) != null) {
                lNumeroLineas++;
            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivosDiscos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            boolean existe = false;
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equalsIgnoreCase(nombre)) {
                    nombres.add(lista1[0]);
                    autor.add(lista1[1]);
                    lista2.add(lista1[3]);
                    precio.add(lista1[4]);
                    existe = true;
                }

            }
            bf2.close();

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        try {
            for (int i = 0; i < 1; i++) {
                jtablecompradisco.setValueAt(nombres.get(i), i, 0);
                jtablecompradisco.setValueAt(autor.get(i), i, 1);
                jtablecompradisco.setValueAt(precio.get(i), i, 2);
                jtablecompradisco.setValueAt(lista2.get(i), i, 3);

            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        if (jtablecompradisco.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtablecompradisco.getModel();
                jtablecompradisco.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void reproducirmusica() {
        if (jlistacompradisco.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione algún Disco para Reproducir!");
        } else {
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Bebe Rexha")) {
                sonido.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Dua Lipa")) {
                sonido2.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("P!nk-What About Us")) {
                sonido3.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Jason Derulo - Swalla")) {
                sonido4.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("La Tierra Canta - Barak")) {
                sonido5.play();
            }
        }
    }

    public void parar() {
        if (jlistacompradisco.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione algún Disco para Reproducir!");
        } else {
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Bebe Rexha")) {
                sonido.stop();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Dua Lipa")) {
                sonido2.stop();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("P!nk-What About Us")) {
                sonido3.stop();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Jason Derulo - Swalla")) {
                sonido4.stop();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("La Tierra Canta - Barak")) {
                sonido5.stop();
            }
        }
    }

}
