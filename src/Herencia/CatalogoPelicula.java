/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class CatalogoPelicula extends ClasePadre {
//this method will have all the variables used to save information on the file as herency
    

    public CatalogoPelicula(String Nombre, String Autor, String Categoria, int Precio, int cantidad) {
        super(Nombre, Autor, Categoria, Precio, cantidad);
        
    }

    public String devolver() {

        return Nombre + ";" + Autor + ";" + Categoria + ";" + Precio + ";" + cantidad;

    }

}
