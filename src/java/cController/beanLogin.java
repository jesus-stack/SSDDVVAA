/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cController;

import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import DAO.UsuarioDLL;
import Model.Tipo.TipoUsuario;
import Model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jesus
 */
@Named(value = "beanLogin")
@SessionScoped
public class beanLogin implements Serializable {
private static Usuario usuario=new Usuario(1, "admin", true, new TipoUsuario(1, "administrador"));
private boolean mantenimiento,facturacion,pedidos,reportes;
    /**
     * Creates a new instance of beanLogin
     */
    public beanLogin() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        beanLogin.usuario = usuario;
    }

    public boolean isMantenimiento() {
          boolean resultado=false;
        if(usuario.getTipo()!=null){
           if(usuario.getTipo().getId()==1||usuario.getTipo().getId()==4){
               resultado=true;
           }
        }
            
        
        return resultado;
    }

    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public boolean isFacturacion() {
        boolean resultado=false;
        if(usuario.getTipo()!=null){
           if(usuario.getTipo().getId()==1||usuario.getTipo().getId()==3){
               resultado=true;
           }
        }
            
        
        return resultado;
    }

    public void setFacturacion(boolean facturacion) {
        this.facturacion = facturacion;
    }

    public boolean isPedidos() {
      boolean resultado=false;
        if(usuario.getTipo()!=null){
         
               resultado=true;
           
        }
            
        
        return resultado;
    }

    public void setPedidos(boolean pedidos) {
        this.pedidos = pedidos;
    }

    public boolean isReportes() {
          boolean resultado=false;
        if(usuario.getTipo()!=null){
           if(usuario.getTipo().getId()==1){
               resultado=true;
           }
        }
            
        
        return resultado;
    }

    public void setReportes(boolean reportes) {
        this.reportes = reportes;
    }
    
    
    
    public void validarUsuario() throws SNMPExceptions{
       
       
        FacesMessage mensajeM=new FacesMessage(FacesMessage.SEVERITY_ERROR,"!DATOS INVALIDOS","!DATOS INVALIDOS");
        FacesMessage mensajeB=new FacesMessage(FacesMessage.SEVERITY_INFO,"!DATOS VALIDOS","!DATOS VALIDOS");
        FacesContext context=FacesContext.getCurrentInstance();
     
        try {
             Usuario usuario1=UsuarioDLL.UsuarioXidentificacion(this.getUsuario().getId());
            if(usuario1.isEstado()==true&&usuario1.getContrasenna().equals(this.getUsuario().getContrasenna())){
                this.setUsuario(usuario1);
               context.addMessage(null, mensajeB);
             
              
            }
            else{
                  this.setUsuario(new Usuario());
                context.addMessage(null, mensajeM);
            }
            
        } catch (Exception e) {
            context.addMessage(null, mensajeM);
        }
        finally{
          
        
            
        }
  }
    
   
}


