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
public class CatalogoDisco extends ClasePadre {

    String ListaCancion;

    public CatalogoDisco(String Nombre, String Autor, String Categoria, String ListaCancion, int Precio, int cantidad) {
        super(Nombre, Autor, Categoria, Precio, cantidad);
        this.ListaCancion = ListaCancion;
    }

    public String devolver() {

        return Nombre + ";" + Autor + ";" + Categoria + ";" + ListaCancion + ";" + Precio + ";" + cantidad;
    }

}
