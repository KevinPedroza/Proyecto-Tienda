/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Herencia.UsuarioRegister;
import static Interfaces.Registro.formucedula;
import static Interfaces.Registro.formucontra;
import static Interfaces.Registro.formucorreo;
import static Interfaces.Registro.formunombre;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ArchivoUsuario {

    public static String user = "kevinlarios2343@gmail.com";
    public static String password = "kqtuugkyrpavbmqe";

    public static String to = "";
    public static String subject = "Registro";

    public void crearlogin() {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("Usuarios.txt", true));
            bw.close();
        } catch (IOException ex) {
            System.out.println("No se Encontro el archivo" + ex);
        }

    }

    public String obtener() {
        String lista = null;
        try {
            String temp;

            BufferedReader bf = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead = bf.readLine();

            temp = bfRead;
            lista = temp;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
        }

        return lista;
    }

    public static boolean revisaruser() {
        String nom = formunombre.getText();
        boolean repite = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equalsIgnoreCase(nom)) {
                    repite = true;
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return repite;
    }

    public static void enviarcorreo() {
        to = formucorreo.getText();

        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "kevinlarios2343@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Se ha completado Exitosamente su registro señ@r " + formunombre.getText());

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
            JOptionPane.showMessageDialog(null, "Se ha completado el formulario Correctamente!");
            formunombre.setText("");
            formucedula.setText("");
            formucontra.setText("");
            formucorreo.setText("");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }

    public void AnadirUsuario() {
        if (revisaruser() == true) {
            JOptionPane.showMessageDialog(null, "Ese Usuario ya esta en el Sistema!");
        } else {
            try {
                String nombre = formunombre.getText();
                String cedula = formucedula.getText();
                String contra = formucontra.getText();
                String correo = formucorreo.getText();
                boolean continuar = false;
                UsuarioRegister register = new UsuarioRegister(nombre, cedula, contra, correo);
                if (formunombre.getText().equals("") || formucedula.getText().equals("") || formucontra.getText().equals("") || formucorreo.getText().equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
                }
                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Usuarios.txt", true));
                        bw.write(register.register() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }

                    enviarcorreo();

                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
            }
        }
    }

}
