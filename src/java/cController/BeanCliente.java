/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cController;

import DAO.Conexion.SNMPExceptions;
import DAO.TipoUsuarioDLL;
import DAO.UsuarioDLL;
import Model.Cliente;
import Model.Funcionario;
import Model.Tipo.TipoUsuario;
import Model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

/**
 *
 * @author Usuario
 */
@Named(value = "beanCliente")
@SessionScoped
public class BeanCliente implements Serializable {

    Cliente cliente=new Cliente();
    String tipoUsuario;
    String mensaje;
    String error;


    public String getTipoUsuario() {
        return tipoUsuario;
        
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public BeanCliente() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


  
    
    
    
    public void insertarCliente() throws NamingException, SNMPExceptions, SQLException, ClassNotFoundException{
       
            
             try {
                 
               UsuarioDLL.insertarCliente(cliente);
               // mensaje="login.xhtml";
        } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null,
                         new FacesMessage("error" +e.getMessage()));
        }
 
    
           // return mensaje;
      
 
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
   
    
//    public LinkedList <SelectItem> listaTipoUsuario() throws SNMPExceptions{
//    LinkedList lista=new LinkedList();
//        
//        for (TipoUsuario o : UsuarioDLL.listaTipoUsuario()) {
//            if(o.getId()!=1){
//            lista.add(new SelectItem(o.getDescripcion()));
//        }
//            }
//    
//    return lista;
//    }
    
    
 public void InsertarTipoCliente() throws SNMPExceptions{

 }   
    
    
   public void insertarTipoUsuario() throws SNMPExceptions{
   TipoUsuario t =new TipoUsuario();
  cliente.setTipo(t.traerTipo(tipoUsuario));
  
   }
    
    
}
