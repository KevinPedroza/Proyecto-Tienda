/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class Reportes {

    public String leer1() {
        String nombredisco = null;
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
                if (lista1[3].equals("P!nk-What About Us")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leer2() {
        String nombredisco = null;
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
                if (lista1[3].equals("Martin Garrix  Bebe Rexha")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leer3() {
        String nombredisco = null;
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
                if (lista1[3].equals("La Tierra Canta - Barak")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leer4() {
        String nombredisco = null;
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
                if (lista1[3].equals("Jason Derulo - Swalla")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leer5() {
        String nombredisco = null;
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
                if (lista1[3].equals("Martin Garrix Dua Lipa")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public int cantidad1() {
        int cantidad = 0;
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
                if (lista1[0].equals(leer4())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidad2() {
        int cantidad = 0;
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
                if (lista1[0].equals(leer1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidad3() {
        int cantidad = 0;
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
                if (lista1[0].equals(leer2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidad4() {
        int cantidad = 0;
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
                if (lista1[0].equals(leer3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidad5() {
        int cantidad = 0;
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
                if (lista1[0].equals(leer5())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }
}
