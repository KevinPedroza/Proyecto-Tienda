package Archivos;

import Herencia.CatalogoPelicula;
import static Interfaces.AñadirPelicula.autorpeli;
import static Interfaces.AñadirPelicula.cantidadpeli;
import static Interfaces.AñadirPelicula.categoriapeli;
import static Interfaces.AñadirPelicula.preciopeli;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static Interfaces.AñadirPelicula.nombrepeli;
import static Interfaces.EliminarPelicula.beliminar;
import static Interfaces.EliminarPelicula.jeliminarpeli;
import static Interfaces.LeerPelicula.Jtablepelicula;
import static Interfaces.ModificarPeliculas.jmodipeli;
import static Interfaces.ModificarPeliculas.modipeliautor;
import static Interfaces.ModificarPeliculas.modipelicantidad;
import static Interfaces.ModificarPeliculas.modipelicategoria;
import static Interfaces.ModificarPeliculas.modipelinombre;
import static Interfaces.ModificarPeliculas.modipeliprecio;
import Procedimientos.admi;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class ArchivosPeliculas {

    admi ad = new admi();
    BufferedReader bf2;
    BufferedReader bf3;
    BufferedReader bf4;
    BufferedReader bf5;
    BufferedReader bf6;
    BufferedReader bf7;

    public static boolean revisarcat() {
        String cate = categoriapeli.getSelectedItem().toString();
        boolean repite = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[2].equals(cate)) {
                    repite = true;
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return repite;
    }

    public void AnadirDisco() {
        if (revisarcat() == true) {
            JOptionPane.showMessageDialog(null, "Esa Categoria ya esta en el Sistema!");
        } else {
            try {
                String nombre = nombrepeli.getSelectedItem().toString();
                String autor = autorpeli.getText();
                String categoria = categoriapeli.getSelectedItem().toString();
                String precio = preciopeli.getText();
                String cantidad = cantidadpeli.getText();
                int precio2 = Integer.parseInt(precio);
                int cantidad2 = Integer.parseInt(cantidad);
                boolean continuar = false;
                CatalogoPelicula disco = new CatalogoPelicula(nombre, autor, categoria, precio2, cantidad2);
                if (autorpeli.getText().equals("") || preciopeli.getText().equals("") || cantidadpeli.getText().equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
                }
                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Peliculas.txt", true));
                        bw.write(disco.devolver() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }
                    JOptionPane.showMessageDialog(null, "Se ha Registrado la Película Correctamente!");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
            }
        }
    }

    public void leerpelicula() {
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> categoria = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();
        ArrayList<String> condicion = new <String>ArrayList();
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

                nombres.add(lista1[0]);
                autor.add(lista1[1]);
                categoria.add(lista1[2]);
                precio.add(lista1[3]);
                condicion.add(lista1[4]);
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            Jtablepelicula.setValueAt(nombres.get(i), i, 0);
            Jtablepelicula.setValueAt(autor.get(i), i, 1);
            Jtablepelicula.setValueAt(categoria.get(i), i, 2);
            Jtablepelicula.setValueAt(precio.get(i), i, 3);
            Jtablepelicula.setValueAt(condicion.get(i), i, 4);
            if (lNumeroLineas >= Jtablepelicula.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Jtablepelicula.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Jtablepelicula.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Jtablepelicula.getModel();
                Jtablepelicula.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void modificarpeli() {

        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Peliculas.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jmodipeli.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Peliculas.txt"))) {
                            String bfRead2;

                            try {
                                lista1[0] = modipelinombre.getSelectedItem().toString();
                                lista1[1] = modipeliautor.getText();
                                lista1[2] = modipelicategoria.getSelectedItem().toString();
                                lista1[3] = modipeliprecio.getText();
                                lista1[4] = modipelicantidad.getText();
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            File archivo = new File("Peliculas.txt");
                            String inf_nueva = null;
                            try {
                                inf_nueva = lista1[0] + ";" + lista1[1] + ";" + lista1[2] + ";" + lista1[3] + ";" + lista1[4];
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            FileWriter escribir = new FileWriter(archivo, true);

                            try {

                                try (BufferedReader bf1 = new BufferedReader(new FileReader("Peliculas.txt"))) {

                                    String bf1Read;

                                    while ((bf1Read = bf1.readLine()) != null) {
                                        temp2 = bf1Read;

                                        if (temp2.equals(lista)) {
                                            BufferedWriter br = new BufferedWriter(new FileWriter("Peliculas.txt"));

                                            continue;
                                        }
                                        escribir.write(temp2 + "\r\n");
                                    }
                                    escribir.write(inf_nueva + "\r\n");
                                    escribir.close();
                                }

                            } catch (IOException e) {

                            }

                        }

                    } catch (IOException e) {
                        System.err.println("No se encontro el archivo" + e);

                    }
                }

            }
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);

        }
        JOptionPane.showMessageDialog(null, "Pelicula Modificado!");
        String cantidadisco = "0";
        boolean existe = false;
        String nombre = null;

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
                if (lista1[0].equals(obtenernombrepreorden())) {
                    cantidadisco = lista1[4];
                    existe = true;
                    nombre = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        int cantidad = Integer.parseInt(cantidadisco);

        if (cantidad > 0 & existe == true) {
            String correo = null;
            boolean enviar = false;
            try {
                String temp;
                bf2 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));

                temp = "";
                String bfRead;

                while ((bfRead = bf2.readLine()) != null) {

                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(";");
                    if (nombre.equals(obtenernombrepreorden())) {
                        enviar = true;
                    }
                }
                bf2.close();
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
            if (enviar == true) {
                int precio = Integer.parseInt(precio());
                int cantidadsoli = Integer.parseInt(obtenercantidad());
                int total = cantidadsoli * precio;
                ad.enviarcorreopreorden(obtenercorreo(), obtenernombrepreorden(), "Pelicula", obtenercantidad(), String.valueOf(total));
            }

        }

    }

    public String precio() {
        String precio = null;
        try {
            String temp;
            bf3 = new BufferedReader(new FileReader("Peliculas.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf3.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(obtenernombrepreorden())) {
                    precio = lista1[4];
                }
            }
            bf3.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return precio;
    }

    public String obtenercorreo() {

        String can = null;
        try {
            String temp;
            bf4 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf4.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(obtenerusuario())) {
                    can = lista1[4];
                }
            }
            bf4.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenercantidad() {
        String can = null;
        try {
            String temp;
            bf5 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf5.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[1].equals(obtenernombrepreorden())) {
                    can = lista1[3];
                }
            }
            bf5.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenerusuario() {
        String can = null;
        try {
            String temp;
            bf6 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf6.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[1].equals(obtenernombrepreorden())) {
                    can = lista1[0];
                }
            }
            bf6.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenernombrepreorden() {
        String can = null;
        try {
            String temp;
            bf7 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf7.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                can = lista1[1];
            }
            bf7.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;
    }

    public void eliminarpeli() {
        if (jeliminarpeli.isSelectionEmpty()) {
            beliminar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Seleccione algún Elemento!");
            beliminar.setEnabled(true);
        } else {

            Object preg = "Desea eliminar la información de la Pelicula?";
            Object unComponentePadre = null;
            Object unIcono = null;
            String nombre = jeliminarpeli.getSelectedValue();
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Aceptar", "Cancelar"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 1) {

            } else {
                try {
                    String temp;
                    try (BufferedReader bf = new BufferedReader(new FileReader("Peliculas.txt"))) {
                        String bfRead;
                        while ((bfRead = bf.readLine()) != null) {
                            temp = bfRead;
                            String lista = temp;
                            String[] lista1 = lista.split(";");
                            if (lista1[0].equals(nombre)) {

                                try {
                                    File archivo = new File("Peliculas.txt");
                                    FileWriter escribir = new FileWriter(archivo, true);
                                    String temp1;
                                    try (BufferedReader bf1 = new BufferedReader(new FileReader("Peliculas.txt"))) {

                                        String bf1Read;

                                        while ((bf1Read = bf1.readLine()) != null) {
                                            temp1 = bf1Read;

                                            if (temp1.equals(lista)) {
                                                BufferedWriter br = new BufferedWriter(new FileWriter("Peliculas.txt"));

                                                continue;
                                            }
                                            escribir.write(temp1 + "\r\n");
                                        }
                                        escribir.close();

                                    }
                                } catch (IOException e) {

                                }

                            }
                        }

                    }

                } catch (IOException e) {
                    System.err.println("No se encontro el archivo");
                }
                JOptionPane.showMessageDialog(null, "Pelicula Eliminado!");
                admi ad = new admi();
                ad.Cargarmodifica3();
            }

        }
    }

}
