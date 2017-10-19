/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import static Archivos.ArchivoUsuario.password;
import static Archivos.ArchivoUsuario.user;
import Archivos.ArchivosDiscos;
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
import static Interfaces.LeerDisco.Jtable;
import static Interfaces.ListaCompras.listadiscos;
import static Interfaces.ListaCompras.listapeliculas;
import static Interfaces.ListaPreOrden.jtablepreorden;
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    public void listacomprasdisco() {
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("ComprasDiscos.txt");
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> cedula = new <String>ArrayList();
        ArrayList<String> email = new <String>ArrayList();
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("ComprasDiscos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[0]);
                nombres.add(lista1[1]);
                cedula.add(lista1[2]);
                email.add(lista1[3]);
                cantidad.add(lista1[4]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            listadiscos.setValueAt(nombres.get(i), i, 0);
            listadiscos.setValueAt(cedula.get(i), i, 1);
            listadiscos.setValueAt(email.get(i), i, 2);
            listadiscos.setValueAt(disco.get(i), i, 3);
            listadiscos.setValueAt(cantidad.get(i), i, 4);
            if (lNumeroLineas >= listadiscos.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) listadiscos.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (listadiscos.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) listadiscos.getModel();
                listadiscos.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void listacompraspeli() {
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("ComprasPeliculas.txt");
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> cedula = new <String>ArrayList();
        ArrayList<String> email = new <String>ArrayList();
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("ComprasPeliculas.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[0]);
                nombres.add(lista1[1]);
                cedula.add(lista1[2]);
                email.add(lista1[3]);
                cantidad.add(lista1[4]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            listapeliculas.setValueAt(nombres.get(i), i, 0);
            listapeliculas.setValueAt(cedula.get(i), i, 1);
            listapeliculas.setValueAt(email.get(i), i, 2);
            listapeliculas.setValueAt(disco.get(i), i, 3);
            listapeliculas.setValueAt(cantidad.get(i), i, 4);
            if (lNumeroLineas >= listapeliculas.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) listapeliculas.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (listapeliculas.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) listapeliculas.getModel();
                listapeliculas.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void listapreordenes() {
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Pre-Ordenes.txt");
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[1]);
                nombres.add(lista1[0]);
                cantidad.add(lista1[3]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            jtablepreorden.setValueAt(nombres.get(i), i, 0);
            jtablepreorden.setValueAt(disco.get(i), i, 1);
            jtablepreorden.setValueAt(cantidad.get(i), i, 2);
            if (lNumeroLineas >= jtablepreorden.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepreorden.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (jtablepreorden.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepreorden.getModel();
                jtablepreorden.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }
    
    public void enviarcorreopreorden(String correo,String disco,String tipodisco,String cantidad, String total) {
        String to = correo;
        String subject = "Ya llego el Articulo Solicitado";
        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "kevinlarios2343@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Nombre: "+disco+ " Tipo: "+ tipodisco + " Cantidad Solicitada: "+ cantidad+ " Total: "+ total);

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(user));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mensaje.setSubject(subject);
            mensaje.setContent(m);

            Transport t = session.getTransport("smtp");
            t.connect(user, password);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Se ha enviado la notificación al cliente Correctamente!");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }
}
