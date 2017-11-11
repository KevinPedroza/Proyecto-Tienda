
package Procedimientos;
//this class will have all the methods related to buy movies.

import Archivos.ArchivosDiscos;
import static Interfaces.CompraPelicula.busaupeli;
import static Interfaces.CompraPelicula.busnombrepeli;
import static Interfaces.CompraPelicula.jlistapelicula;
import static Interfaces.CompraPelicula.jtablepelicula;
import static Interfaces.CompraPelicula.modelopeli;
import static Interfaces.CompraPelicula.precio1;
import static Interfaces.CompraPelicula.precio2;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class Usuariocompeli {

    public void Cargarnombre() {
        //this method will charge the names of the movies according to the parameters
        String buscarname = busnombrepeli.getText();
        String busautor = busaupeli.getText();
        String busprecio = precio1.getText();
        String busprecio2 = precio2.getText();
        int precio11 = 0;
        int precio22 = 0;
        boolean vacio = false;
        if (busnombrepeli.getText().equals("") & busaupeli.getText().equals("") & precio1.getText().equals("") & precio2.getText().equals("")) {
            vacio = true;
            JOptionPane.showMessageDialog(null, "Ingrese algún Parametro de busqueda!");

        }
        if (vacio == false) {
            modelopeli.clear();

            try {
                precio11 = Integer.parseInt(busprecio);
                precio22 = Integer.parseInt(busprecio2);
            } catch (java.lang.NumberFormatException e) {
            }
            boolean existe = false;
            String nombre = null;
            try {
                String temp;
                BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));

                temp = "";
                String bfRead;
                while ((bfRead = bf2.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;

                    String[] lista1 = lista.split(";");

                    if (lista1[0].equalsIgnoreCase(buscarname) || lista1[1].equalsIgnoreCase(busautor) || (Integer.parseInt(lista1[3]) <= precio22 & Integer.parseInt(lista1[3]) >= precio11)) {

                        modelopeli.addElement(lista1[0]);
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
        //this method will show the information of a movie according to what the customer selected.

        String nombre = jlistapelicula.getSelectedValue();

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();

        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Peliculas.txt");
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
            BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equalsIgnoreCase(nombre)) {
                    nombres.add(lista1[0]);
                    autor.add(lista1[1]);
                    precio.add(lista1[3]);
                    existe = true;
                }

            }
            bf2.close();

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        try {
            for (int i = 0; i < 1; i++) {
                jtablepelicula.setValueAt(nombres.get(i), i, 0);
                jtablepelicula.setValueAt(autor.get(i), i, 1);
                jtablepelicula.setValueAt(precio.get(i), i, 2);

            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        if (jtablepelicula.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepelicula.getModel();
                jtablepelicula.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void reproducirvideo() throws IOException {
        //this method will play the videos that the customers selected.
        if (jlistapelicula.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione una Pelicula para Reproducir!");
        } else {

            if (jlistapelicula.getSelectedValue().equals("IT")) {
                String file = new String("It Trailer #1 (2017) - Movieclips Trailers.mp4");
                File path = new File(file);
                Desktop.getDesktop().open(path);
            }
            if (jlistapelicula.getSelectedValue().equals("BiG MAMA")) {
                String file = new String("Big Momma's House Theatrical Trailer (2000) (1).mp4");
                File path = new File(file);
                Desktop.getDesktop().open(path);
            }
            if (jlistapelicula.getSelectedValue().equals("Titanes del Pacifico")) {
                String file = new String("TITANES DEL PACÍFICO - Tráiler 1 subtitulado HD - Oficial de Warner Bros. Pictures.mp4");
                File path = new File(file);
                Desktop.getDesktop().open(path);

            }
            if (jlistapelicula.getSelectedValue().equals("El cazador de Brujas")) {
                String file = new String("EL ÚLTIMO CAZADOR DE BRUJAS Tráiler Oficial Español.mp4");
                File path = new File(file);
                Desktop.getDesktop().open(path);
            }
            if (jlistapelicula.getSelectedValue().equals("Before You")) {
                String file = new String("Yo Antes de Ti (Me Before You) - Tráiler 1 Oficial Subtitulado en HD.mp4");
                File path = new File(file);
                Desktop.getDesktop().open(path);
            }
        }

    }

}
