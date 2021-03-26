/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jesus
 */
public class Producto {
   private int id;
   private String nombre, descripcion;
   private double precio;
   private InputStream foto;
   private int cantidadMinimaVenta;
   private StreamedContent imagen;
   
   

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, double precio,InputStream foto, int cantidadMinimaVenta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.cantidadMinimaVenta = cantidadMinimaVenta;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public int getCantidadMinimaVenta() {
        return cantidadMinimaVenta;
    }

    public void setCantidadMinimaVenta(int cantidadMinimaVenta) {
        this.cantidadMinimaVenta = cantidadMinimaVenta;
    }

    public StreamedContent getImagen() throws IOException {
        imagen();
        return imagen;
    }

    public void setImagen(StreamedContent imagen) {
        this.imagen = imagen;
    }

public void imagen() throws IOException{
           this.setImagen(new DefaultStreamedContent(foto));
        
}
   
}
