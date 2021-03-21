/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cController;

import DAO.Conexion.SNMPExceptions;
import DAO.ProductoDB;
import Model.Producto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Jesus
 */
@Named(value = "beanProducto")
@SessionScoped
public class beanProducto implements Serializable {
private Producto producto=new Producto();
private UploadedFile fileImagen;
private LinkedList<Producto> lista;
private LinkedList listaCodigo;

    public LinkedList getListaCodigo() {
        return llenarLista();
    }

    public void setListaCodigo(LinkedList listaCodigo) {
        this.listaCodigo = listaCodigo;
    }


    public beanProducto() {
    }
   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public UploadedFile getFileImagen() {
        return fileImagen;
    }

    public void setFileImagen(UploadedFile fileImagen) {
        this.fileImagen = fileImagen;
    }

    public LinkedList<Producto> getLista() throws SNMPExceptions {

     return ProductoDB.listaProductos();
     
    }

    public void setLista(LinkedList<Producto> lista) {
        this.lista = lista;
    }
    
    public void AgregarProducto() throws IOException, SNMPExceptions{
        try{
            
  ProductoDB.AgregarProducto(producto, fileImagen.getInputStream());
      FacesMessage message=new FacesMessage("exito", fileImagen.getFileName()+" fue recibido");
          FacesContext.getCurrentInstance().addMessage(null, message);
          
      } catch(Exception e){
          FacesMessage message=new FacesMessage("error de conexion "+e.getMessage() );
          FacesContext.getCurrentInstance().addMessage(null, message);
      }  
    }
    public StreamedContent imagen(byte[] input) throws IOException{
        if(input!=null){
           InputStream in=new ByteArrayInputStream(input);
        
        return new DefaultStreamedContent(in,"image/png");
        }
        else{
            return new DefaultStreamedContent();
        }
    }
    
    public LinkedList llenarLista(){
    
     lista=new LinkedList(); 
    lista.add(new Producto(0, "Salsa Inglesa", "Rica salsa para sasonar nuestras comidas", 2000, null, 5));
    lista.add(new Producto(1, "Arroz", "Arroz blanco tio pelón en tarros de 3 kilogramos para toda la semana", 2000, null, 5));
    lista.add(new Producto(2, "Pinto", "Gallo pinto constarricense con excelente sabor para que disfrute de sus mañanas con su familia", 2000, null, 5));
    lista.add(new Producto(3, "Carne asada", "Rica Carne asada con barbacoa ", 2000, null, 5));
     lista.add(new Producto(0, "Salsa Inglesa", "Rica salsa para sasonar nuestras comidas", 2000, null, 5));
    lista.add(new Producto(1, "Arroz", "Arroz blanco tio pelón en tarros de 3 kilogramos para toda la semana", 2000, null, 5));
    lista.add(new Producto(2, "Pinto", "Gallo pinto constarricense con excelente sabor para que disfrute de sus mañanas con su familia", 2000, null, 5));
    lista.add(new Producto(3, "Carne asada", "Rica Carne asada con barbacoa ", 2000, null, 5));
    
 
return lista;   
}
  
    
}
