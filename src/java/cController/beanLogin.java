/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cController;

import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import DAO.UsuarioDLL;
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
private static Usuario usuario=new Usuario();
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
    
    public String validarUsuario() throws SNMPExceptions{
        String action="PF('log').show()";
       
        FacesMessage mensajeM=new FacesMessage(FacesMessage.SEVERITY_ERROR,"!DATOS INVALIDOS","!DATOS INVALIDOS");
        FacesMessage mensajeB=new FacesMessage(FacesMessage.SEVERITY_INFO,"!DATOS VALIDOS","!DATOS VALIDOS");
        FacesContext context=FacesContext.getCurrentInstance();
     
        try {
             Usuario usuario1=UsuarioDLL.UsuarioXidentificacion(this.getUsuario().getId());
            if(usuario1.isEstado()==true&&usuario1.getContrasenna().equals(this.getUsuario().getContrasenna())){ 
               context.addMessage(null, mensajeB);
               action="PF('log').dispose()";
              
            }
            else{
                context.addMessage(null, mensajeM);
            }
            
        } catch (Exception e) {
            context.addMessage(null, mensajeM);
        }
        finally{
            return action;
        
            
        }
  }
}


