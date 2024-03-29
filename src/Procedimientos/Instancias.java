/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.ArchivosDiscos;
import Interfaces.AñadirDisco;
import Interfaces.AñadirPelicula;
import Interfaces.CompraDisco;
import Interfaces.CompraPelicula;
import Interfaces.Elegir_Usuario;
import Interfaces.Elegir_usupeli;
import Interfaces.EliminarDisco;
import Interfaces.EliminarPelicula;
import Interfaces.Fecha_Fin;
import Interfaces.Fecha_Inicio;
import Interfaces.Fechafin_Peli;
import Interfaces.Fechaini_Peli;
import Interfaces.LeerDisco;
import Interfaces.LeerPelicula;
import Interfaces.ListaCompras;
import Interfaces.ListaPreOrden;
import Interfaces.Menu;
import Interfaces.ModificarDisco;
import Interfaces.ModificarPeliculas;
import Interfaces.Opciones;
import Interfaces.OpcionesCatalogoMusica;
import Interfaces.OpcionesCatalogoPelicula;
import Interfaces.ProcesoCompraDisco;
import Interfaces.ProcesoCompraPelicula;
import Interfaces.Registro;
import Interfaces.Reportes;
import Interfaces.Usuario;
import Interfaces.UsuarioCatalogo;
import javax.swing.JFrame;

/**
 *
 * @author Kevin
 */
public class Instancias extends JFrame {

    //this method is gonna call all jframes in the interfaz package each public void is gonna call the name of the jframe that it has up there
    public void catalogomusica() {
        OpcionesCatalogoMusica catalogo = new OpcionesCatalogoMusica(this, true);
        catalogo.pack();
        catalogo.setVisible(true);
    }

    public void catalogopelicula() {
        OpcionesCatalogoPelicula catalogo = new OpcionesCatalogoPelicula(this, true);
        catalogo.pack();
        catalogo.setVisible(true);
    }

    public void catalogos() {
        Opciones catalogo = new Opciones(this, true);
        catalogo.pack();
        catalogo.setVisible(true);
    }

    public void leerdiscos() {
        LeerDisco leer = new LeerDisco(this, true);
        leer.pack();
        leer.setVisible(true);
    }

    public void añadirdisco() {
        AñadirDisco leer = new AñadirDisco(this, true);
        leer.pack();
        leer.setVisible(true);
    }

    public void modificardisco() {
        ModificarDisco disco = new ModificarDisco(this, true);
        disco.pack();
        disco.setVisible(true);

    }

    public void eliminardisco() {
        EliminarDisco disco = new EliminarDisco(this, true);
        disco.pack();
        disco.setVisible(true);
    }

    public void añadirpelicula() {
        AñadirPelicula peli = new AñadirPelicula(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void leerpeli() {
        LeerPelicula peli = new LeerPelicula(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void modificarpeli() {
        ModificarPeliculas peli = new ModificarPeliculas(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void eliminarpeli() {
        EliminarPelicula peli = new EliminarPelicula(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void loginusuario() {
        Usuario user = new Usuario(this, true);
        user.pack();
        user.setVisible(true);

    }

    public void registro() {
        Registro re = new Registro(this, true);
        re.pack();
        re.setVisible(true);

    }

    public void modocompra() {
        UsuarioCatalogo user = new UsuarioCatalogo(this, true);
        user.pack();
        user.setVisible(true);

    }

    public void compradisco() {
        CompraDisco disco = new CompraDisco(this, true);
        disco.pack();
        disco.setVisible(true);

    }

    public void comprapelicula() {
        CompraPelicula disco = new CompraPelicula(this, true);
        disco.pack();
        disco.setVisible(true);

    }

    public void procesocomdisco() {

        ProcesoCompraDisco disco = new ProcesoCompraDisco(this, true);
        disco.pack();
        disco.setVisible(true);

    }

    public void procesopeli() {
        ProcesoCompraPelicula peli = new ProcesoCompraPelicula(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void listacompras() {
        ListaCompras lista = new ListaCompras(this, true);
        lista.pack();
        lista.setVisible(true);

    }

    public void preordenes() {
        ListaPreOrden pre = new ListaPreOrden(this, true);
        pre.pack();
        pre.setVisible(true);

    }

    public void reportes() {
        Reportes re = new Reportes(this, true);
        re.pack();
        re.setVisible(true);

    }

    public void elegir_usuariodisco() {

        Elegir_Usuario ele = new Elegir_Usuario(this, true);
        ele.pack();
        ele.setVisible(true);

    }

    public void elegir_usuariopeli() {

        Elegir_usupeli ele = new Elegir_usupeli(this, true);
        ele.pack();
        ele.setVisible(true);

    }

    public void fechafin() {
        Fecha_Fin fin = new Fecha_Fin(this, true);
        fin.pack();
        fin.setVisible(true);

    }

    public void fechaini() {
        Fecha_Inicio ini = new Fecha_Inicio(this, true);
        ini.pack();
        ini.setVisible(true);
    }

    public void fechaini_peli() {
        Fechaini_Peli peli = new Fechaini_Peli(this, true);
        peli.pack();
        peli.setVisible(true);

    }

    public void fechafin_peli() {

        Fechafin_Peli peli = new Fechafin_Peli(this, true);
        peli.pack();
        peli.setVisible(true);
    }

}
