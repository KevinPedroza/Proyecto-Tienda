/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.login;
import Interfaces.Administrador;
import static Interfaces.Administrador.contraadmi;
import static Interfaces.Administrador.usuario;
import static Interfaces.AñadirDisco.categorias;
import static Interfaces.AñadirDisco.listascanciones;
import static Interfaces.AñadirPelicula.categoriapeli;
import static Interfaces.AñadirPelicula.nombrepeli;
import static Interfaces.EliminarDisco.Jeliminar;
import static Interfaces.EliminarPelicula.jeliminarpeli;
import static Interfaces.ModificarDisco.Jlist;
import static Interfaces.ModificarDisco.modiautor;
import static Interfaces.ModificarDisco.modicantidad;
import static Interfaces.ModificarDisco.modicategoria;
import static Interfaces.ModificarDisco.modilistas;
import static Interfaces.ModificarDisco.modinombre;
import static Interfaces.ModificarDisco.modiprecio;
import static Interfaces.ModificarPeliculas.jmodipeli;
import static Interfaces.ModificarPeliculas.modipeliautor;
import static Interfaces.ModificarPeliculas.modipelicantidad;
import static Interfaces.ModificarPeliculas.modipelicategoria;
import static Interfaces.ModificarPeliculas.modipelinombre;
import static Interfaces.ModificarPeliculas.modipeliprecio;
import Interfaces.Opciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class admi extends JFrame {

    public static DefaultListModel modelo;

    public String[] leer() {
        login lo = new login();
        lo.crearlogin();
        String info = lo.obtener();

        String[] posi = info.split(",");

        return posi;
    }

    public void ingre() {

        String[] info = leer();
        String usu = info[0];
        String contra = info[1];
        String u = usuario.getText();
        String c = contraadmi.getText();
        if (u.equals(usu) & c.equals(contra)) {
            JOptionPane.showMessageDialog(null, "Login Correcto!");
            Opciones catalogos = new Opciones(this, true);
            catalogos.pack();
            catalogos.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Contraseña o Usuario Incorrecto!");
            usuario.setText("");
            contraadmi.setText("");
            new Administrador(this, true).setVisible(true);
        }

    }

    public void Cargar() {
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        Jlist.setModel(modelo);

    }

    public void Cargar2() {
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        Jeliminar.setModel(modelo);

    }

    public void cargardatos() {
        String nombre = Jlist.getSelectedValue();
        boolean esta = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(nombre)) {
                    modinombre.setText(lista1[0]);
                    modiautor.setText(lista1[1]);
                    modicategoria.setSelectedItem(lista1[2]);
                    modilistas.setSelectedItem(lista1[3]);
                    modiprecio.setText(lista1[4]);
                    modicantidad.setText(lista1[5]);

                } else {
                    esta = true;
                }

            }

            bf2.close();
            if (esta == false) {
                JOptionPane.showMessageDialog(null, "No esta en el Registro o Seleccione un Nombre!");
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
    }

    public void elegircategoriapeli() {

        if (categoriapeli.getSelectedItem().equals("Terror")) {
            nombrepeli.addItem("IT");
            nombrepeli.setSelectedItem("IT");
        }
        if (categoriapeli.getSelectedItem().equals("Comedia")) {
            nombrepeli.addItem("BiG MAMA");
            nombrepeli.setSelectedItem("BiG MAMA");
        }
        if (categoriapeli.getSelectedItem().equals("Acción")) {
            nombrepeli.addItem("Titanes del Pacifico");
            nombrepeli.setSelectedItem("Titanes del Pacifico");
        }
        if (categoriapeli.getSelectedItem().equals("Suspenso")) {
            nombrepeli.addItem("El cazador de Brujas");
            nombrepeli.setSelectedItem("El cazador de Brujas");

        }
        if (categoriapeli.getSelectedItem().equals("Drama")) {
            nombrepeli.addItem("Before You");
            nombrepeli.setSelectedItem("Before You");
        }
        nombrepeli.setEnabled(false);
    }

    public void elegircategoriaDisco() {

        if (categorias.getSelectedItem().equals("Merengue")) {

            listascanciones.setSelectedItem("Jason Derulo - Swalla");
        }
        if (categorias.getSelectedItem().equals("Electronica")) {

            listascanciones.setSelectedItem("P!nk-What About Us");
        }
        if (categorias.getSelectedItem().equals("Salsa")) {

            listascanciones.setSelectedItem("Martin Garrix  Bebe Rexha");
        }
        if (categorias.getSelectedItem().equals("Cristiana")) {

            listascanciones.setSelectedItem("La Tierra Canta - Barak");

        }
        if (categorias.getSelectedItem().equals("Cumbia")) {

            listascanciones.setSelectedItem("Martin Garrix Dua Lipa");
        }
        listascanciones.setEnabled(false);
    }

    public void cargardatosmodipeli() {
        String nombre = jmodipeli.getSelectedValue();
        boolean esta = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(nombre)) {
                    modipelicategoria.setSelectedItem(lista1[2]);
                    modipelinombre.setSelectedItem(lista1[0]);
                    modipeliautor.setText(lista1[1]);
                    modipeliprecio.setText(lista1[3]);
                    modipelicantidad.setText(lista1[4]);

                } else {
                    esta = true;
                }

            }

            bf2.close();
            if (esta == false) {
                JOptionPane.showMessageDialog(null, "No esta en el Registro o Seleccione un Nombre!");
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

    }

    public void Cargarmodifica2() {
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        jmodipeli.setModel(modelo);

    }

    public void Cargarmodifica3() {
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        jeliminarpeli.setModel(modelo);

    }
}
