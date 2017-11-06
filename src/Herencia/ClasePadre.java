package Herencia;

/**
 *
 * @author Kevin
 */
public class ClasePadre {
//this is the father class where the others son classes get the principal variables

    String Nombre;
    String Autor;
    String Categoria;
    int Precio;
    int cantidad;

    public ClasePadre(String Nombre, String Autor, String Categoria, int Precio, int cantidad) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Categoria = Categoria;

        this.Precio = Precio;
        this.cantidad = cantidad;
    }

}
