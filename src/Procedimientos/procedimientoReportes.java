package Procedimientos;

import static Interfaces.Elegir_Usuario.listausuario;
import static Interfaces.Elegir_Usuario.modelousu;
import static Interfaces.Elegir_usupeli.listapeliuser;
import static Interfaces.Elegir_usupeli.modelousupeli;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kevin
 */
public class procedimientoReportes {
    
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
    
    public String leerpeli1() {
        String nombredisco = null;
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
                if (lista1[0].equals("El cazador de Brujas")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return nombredisco;
    }
    
    public String leerpeli2() {
        String nombredisco = null;
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
                if (lista1[0].equals("BiG MAMA")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return nombredisco;
    }
    
    public String leerpeli3() {
        String nombredisco = null;
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
                if (lista1[0].equals("Titanes del Pacifico")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return nombredisco;
    }
    
    public String leerpeli4() {
        String nombredisco = null;
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
                if (lista1[0].equals("IT")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return nombredisco;
    }
    
    public String leerpeli5() {
        String nombredisco = null;
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
                if (lista1[0].equals("Before You")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return nombredisco;
    }
    
    public int cantidadpeli1() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli4())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int cantidadpeli2() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int cantidadpeli3() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int cantidadpeli4() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int cantidadpeli5() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli5())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public void llenar_list() {
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));
            
            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                
                String[] lista1 = lista.split(";");
                
                modelousu.addElement(lista1[0]);
                
            }
            
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
    }
    
    public void llenar_listpeli() {
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));
            
            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                
                String[] lista1 = lista.split(";");
                
                modelousupeli.addElement(lista1[0]);
                
            }
            
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
    }
    
    public int usercanti() {
        String nombre = listausuario.getSelectedValue();
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leer4())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int usercanti2() {
        String nombre = listausuario.getSelectedValue();
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leer2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int usercanti3() {
        String nombre = listausuario.getSelectedValue();
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leer1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int usercanti4() {
        String nombre = listausuario.getSelectedValue();
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leer3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int usercanti5() {
        
        String nombre = listausuario.getSelectedValue();
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leer5())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
    }
    
    public int userpeli() {
        
        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
        
    }
    
    public int userpeli2() {
        
        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli4())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
        
    }
    
    public int userpeli3() {
        
        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli5())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
        
    }
    
    public int userpeli4() {
        
        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
        
    }
    
    public int userpeli5() {
        
        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        return cantidad;
        
    }
    
    public CategoryDataset cargardisco() {
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(usercanti(), "Merengue", "Merengue");
        Datos3.addValue(usercanti2(), "Salsa", "Salsa");
        Datos3.addValue(usercanti3(), "Electronica", "Electronica");
        Datos3.addValue(usercanti4(), "Cristiana", "Cristiana");
        Datos3.addValue(usercanti5(), "Cumbia", "Cumbia");
        
        return Datos3;
    }
    
    public CategoryDataset cargarpeli() {
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(userpeli(), "Accíon", "Accíon");
        Datos3.addValue(userpeli2(), "Terror", "Terror");
        Datos3.addValue(userpeli3(), "Drama", "Drama");
        Datos3.addValue(userpeli4(), "Suspenso", "Suspenso");
        Datos3.addValue(userpeli5(), "Comedia", "Comedia");
        
        return Datos3;
    }
}
