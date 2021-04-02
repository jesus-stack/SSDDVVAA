/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Conexion.SNMPExceptions;
import DAO.ProductoDB;
import Model.Producto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jesus
 */
@Named(value = "beanProducto")
@SessionScoped
public class beanProducto implements Serializable {
private Producto producto=new Producto();

private LinkedList<Producto> lista;
private LinkedList<Producto> listaCodigo;

    public LinkedList<Producto> getListaCodigo() {
        return llenarLista();
    }

    public void setListaCodigo(LinkedList<Producto> listaCodigo) {
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

    

 

    public LinkedList<Producto> getLista() throws SNMPExceptions {

     return ProductoDB.listaProductos();
     
    }

    public void setLista(LinkedList<Producto> lista) {
        this.lista = lista;
    }
    
    public void AgregarProducto() throws IOException, SNMPExceptions{
        try{
            
  ProductoDB.AgregarProducto(producto);
      FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,"EXITO", "\nProducto registrado ");
          FacesContext.getCurrentInstance().addMessage("msg", message);
          producto=new Producto();
          
      } catch(Exception e){
          FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","Ha ocurrido un problema, intentelo mas tarde" );
          FacesContext.getCurrentInstance().addMessage("msg", message);
      }  
    }

       public void EliminarProducto(Producto pro) throws IOException, SNMPExceptions{
        try{
            
  ProductoDB.EliminarProducto(pro);
      FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,"EXITO", "\nProducto Eliminado ");
          FacesContext.getCurrentInstance().addMessage("msg", message);
          producto=new Producto();
          
      } catch(Exception e){
          FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","Ha ocurrido un problema, intentelo mas tarde" );
          FacesContext.getCurrentInstance().addMessage("msg", message);
      }  
    }
       public void nuevo(){
           this.setProducto(new Producto());
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
 public void editarProducto(Producto producto){
     this.setProducto(producto);
 }

}
