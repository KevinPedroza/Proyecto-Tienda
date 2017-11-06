/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Herencia.CatalogoDisco;
import static Interfaces.AñadirDisco.autordisco;
import static Interfaces.AñadirDisco.cantidadiscos;
import static Interfaces.AñadirDisco.categorias;
import static Interfaces.AñadirDisco.listascanciones;
import static Interfaces.AñadirDisco.nombredisco;
import static Interfaces.AñadirDisco.preciodisco;
import static Interfaces.EliminarDisco.Jeliminar;
import static Interfaces.EliminarPelicula.beliminar;
import static Interfaces.LeerDisco.Jtable;
import static Interfaces.ModificarDisco.Jlist;
import static Interfaces.ModificarDisco.modiautor;
import static Interfaces.ModificarDisco.modicantidad;
import static Interfaces.ModificarDisco.modicategoria;
import static Interfaces.ModificarDisco.modilistas;
import static Interfaces.ModificarDisco.modinombre;
import static Interfaces.ModificarDisco.modiprecio;
import Procedimientos.admi;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class ArchivosDiscos {

    admi ad = new admi();
    BufferedReader bf2;
    BufferedReader bf3;
    BufferedReader bf4;
    BufferedReader bf5;
    BufferedReader bf6;
    BufferedReader bf7;

    public static boolean revisarcat() {
        //this method will check if a category is already on the file
        String cate = categorias.getSelectedItem().toString();
        boolean repite = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

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
        // this method will add a new discs
        if (revisarcat() == true) {
            JOptionPane.showMessageDialog(null, "Esa Categoria ya esta en el Sistema!");
        } else {
            try {
                String nombre = nombredisco.getText();
                String autor = autordisco.getText();
                String categoria = categorias.getSelectedItem().toString();
                String precio = preciodisco.getText();
                String lista = listascanciones.getSelectedItem().toString();
                String cantidad = cantidadiscos.getText();
                int precio2 = Integer.parseInt(precio);
                int cantidad2 = Integer.parseInt(cantidad);
                boolean continuar = false;
                CatalogoDisco disco = new CatalogoDisco(nombre, autor, categoria, lista, precio2, cantidad2);

                if (nombredisco.getText().equals("") || autordisco.getText().equals("") || precio.equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
                }

                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Discos.txt", true));
                        bw.write(disco.devolver() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }
                    JOptionPane.showMessageDialog(null, "Se ha Registrado el Disco Correctamente!");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
            }
        }

    }

    public void leerdisco() {
        //this method will read all of the disc on the file
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> categoria = new <String>ArrayList();
        ArrayList<String> lista2 = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();
        ArrayList<String> condicion = new <String>ArrayList();
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

                nombres.add(lista1[0]);
                autor.add(lista1[1]);
                categoria.add(lista1[2]);
                lista2.add(lista1[3]);
                precio.add(lista1[4]);
                condicion.add(lista1[5]);
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            Jtable.setValueAt(nombres.get(i), i, 0);
            Jtable.setValueAt(autor.get(i), i, 1);
            Jtable.setValueAt(categoria.get(i), i, 2);
            Jtable.setValueAt(lista2.get(i), i, 3);
            Jtable.setValueAt(precio.get(i), i, 4);
            Jtable.setValueAt(condicion.get(i), i, 5);
            if (lNumeroLineas >= Jtable.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Jtable.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Jtable.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Jtable.getModel();
                Jtable.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public void modificar() {
        //this method will modify the disc that the admi wants to change
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (Jlist.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"))) {
                            String bfRead2;

                            try {
                                lista1[0] = modinombre.getText();
                                lista1[1] = modiautor.getText();
                                lista1[2] = modicategoria.getSelectedItem().toString();
                                lista1[3] = modilistas.getSelectedItem().toString();
                                lista1[4] = modiprecio.getText();
                                lista1[5] = modicantidad.getText();
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            File archivo = new File("Discos.txt");
                            String inf_nueva = null;
                            try {
                                inf_nueva = lista1[0] + ";" + lista1[1] + ";" + lista1[2] + ";" + lista1[3] + ";" + lista1[4] + ";" + lista1[5];
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            FileWriter escribir = new FileWriter(archivo, true);

                            try {

                                try (BufferedReader bf1 = new BufferedReader(new FileReader("Discos.txt"))) {

                                    String bf1Read;

                                    while ((bf1Read = bf1.readLine()) != null) {
                                        temp2 = bf1Read;

                                        if (temp2.equals(lista)) {
                                            BufferedWriter br = new BufferedWriter(new FileWriter("Discos.txt"));

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
        JOptionPane.showMessageDialog(null, "Disco Modificado!");

        String cantidadisco = "0";
        boolean existe = false;
        String nombre = null;

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
                if (lista1[0].equals(obtenernombrepreorden())) {
                    cantidadisco = lista1[5];
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
                int contador = 0;

                temp = "";
                String bfRead;

                while ((bfRead = bf2.readLine()) != null) {
                    contador++;
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
                ad.enviarcorreopreorden(obtenercorreo(), obtenernombrepreorden(), "Disco", obtenercantidad(), String.valueOf(total));
            }

        }
    }

    public String precio() {
        //this method wil let you get the price of a disc
        String precio = null;
        try {
            String temp;
            bf3 = new BufferedReader(new FileReader("Discos.txt"));
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
        //this method will get the email of a pre-order

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
        //this method will get the quantity of a disc on the file pre-orders
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
        //this method will get the user on the file pre-orders.txt
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
        //this method will get the name of the pre-order.
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

    public void eliminardisco() {
        //this method wil delete a disc that the admi wants to delete
        if (Jeliminar.isSelectionEmpty()) {
            beliminar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Seleccione algún Elemento!");
            beliminar.setEnabled(true);
        } else {
            Object preg = "Desea eliminar la información del Disco?";
            Object unComponentePadre = null;
            Object unIcono = null;
            String nombre = Jeliminar.getSelectedValue();
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Aceptar", "Cancelar"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 1) {

            } else {
                try {
                    String temp;
                    try (BufferedReader bf = new BufferedReader(new FileReader("Discos.txt"))) {
                        String bfRead;
                        while ((bfRead = bf.readLine()) != null) {
                            temp = bfRead;
                            String lista = temp;
                            String[] lista1 = lista.split(";");
                            if (lista1[0].equals(nombre)) {

                                try {
                                    File archivo = new File("Discos.txt");
                                    FileWriter escribir = new FileWriter(archivo, true);
                                    String temp1;
                                    try (BufferedReader bf1 = new BufferedReader(new FileReader("Discos.txt"))) {

                                        String bf1Read;

                                        while ((bf1Read = bf1.readLine()) != null) {
                                            temp1 = bf1Read;

                                            if (temp1.equals(lista)) {
                                                BufferedWriter br = new BufferedWriter(new FileWriter("Discos.txt"));

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
                JOptionPane.showMessageDialog(null, "Disco Eliminado!");
                admi ad = new admi();
                ad.Cargar2();
            }

        }
    }

}
