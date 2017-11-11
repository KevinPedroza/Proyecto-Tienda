
package Procedimientos;
//this class will get all methods for the customer buy a compac disc
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
import java.util.Arrays;

/**
 *
 * @author Kevin
 */
public class Usuariocomdisco extends JFrame {
    
    //all of these contains all the addresses of the songs for me to play it.
    AudioClip sonido;
    AudioClip sonido2;
    AudioClip sonido3;
    AudioClip sonido4;
    AudioClip sonido5;
    public static String usuario;
    public static String correouser;
    ArchivoUsuario lo = new ArchivoUsuario();
    public void sonido(){
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Martin Garrix Bebe Rexha - In The Name Of Love (Official Video) (online-audio-converter.com).wav"));
    }
    public void sonido2(){
        sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Martin Garrix Dua Lipa - Scared To Be Lonely (Official Video) (online-audio-converter.com).wav"));
    }
    public void sonido3(){
        sonido3 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/P!nk - What About Us (Shaun Barron Bootleg) (online-audio-converter.com).wav"));
    }
    public void sonido4(){
        sonido4 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/Jason Derulo - Swalla (feat. Nicki Minaj Ty Dolla $ign) (Official Music Video) (online-audio-converter.com).wav"));
    }
    public void sonido5(){
    sonido5 = java.applet.Applet.newAudioClip(getClass().getResource("/Canciones/La Tierra Canta - Barak (letra)_3P6KiEY_zA0_youtube (online-audio-converter.com).wav"));
    }
    public String[] leer() {
        //this method will read if the file contains information
        lo.crearlogin();
        String info = lo.obtener();
        
        String[] posi = info.split(";");
        
        return posi;
    }
    
    public static boolean vacio() {
        //this method will verify if there is information on the file
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
    
    public String obtenerusuaio() {
        //this method will get the user that the customer is getting input
        String user = usunombre.getText();
        String usuario = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));
            
            temp = "";
            String bfRead;
            
            while ((bfRead = bf2.readLine()) != null) {
                
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(user)) {
                    usuario = lista1[0];
                }
                
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return usuario;
    }
    
    public String obtenercontra() {
        //this method will get the password that the user is getting input.
        String con = usucontra.getText();
        String user = usunombre.getText();
        String usuario = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));
            
            temp = "";
            String bfRead;
            
            while ((bfRead = bf2.readLine()) != null) {
                
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(user) & lista1[2].equals(con)) {
                    usuario = lista1[2];
                }
                
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return usuario;
    }
    
    public void ingreusu() {
        //this method will verify if the customer is introducing a correct password and username.
        
        if (vacio() == true) {
            
            try {
                
                String usu = obtenerusuaio();
                String contra = obtenercontra();
                String u = usunombre.getText();
                String c = usucontra.getText();
                if (u.equals(usu) & c.equals(contra)) {
                    JOptionPane.showMessageDialog(null, "Login Correcto!");
                    usuario = u;
                    correouser = c;
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
        //this method will get the name of the song according to the parameters that the customer introduces it.
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
                        
                    } else {
                        existe = false;
                        
                    }
                    
                }
                
                bf2.close();
                if (existe == false) {
                    JOptionPane.showMessageDialog(null, "No se encuentra el Disco en ese tipo de Parametro!");
                }
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
        }
        
    }
    
    public void mostrarinfor() {
        //this method will show the information that customer is introducing on the jtable
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
        //this method will play the songs that the customer wants to reproduce
        if (jlistacompradisco.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione algún Disco para Reproducir!");
        } else {
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Bebe Rexha")) {
                sonido();
                sonido.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Martin Garrix  Dua Lipa")) {
                sonido2();
                sonido2.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("P!nk-What About Us")) {
                sonido3();
                sonido3.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("Jason Derulo - Swalla")) {
                sonido4();
                sonido4.play();
            }
            if (jtablecompradisco.getValueAt(0, 3).equals("La Tierra Canta - Barak")) {
                sonido5();
                sonido5.play();
            }
        }
    }
    
    public void parar() {
        //this method will stop the songs that the customer wants
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
