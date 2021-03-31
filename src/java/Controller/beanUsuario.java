/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDLL;
import Model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jesus
 */
@Named(value = "beanUsuario")
@SessionScoped
public class beanUsuario implements Serializable {

    private LinkedList<Usuario> usuarios;
    public beanUsuario() {
    }

    public LinkedList<Usuario> getUsuarios() {
        llenarLista();
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void llenarLista(){
        try{
            usuarios=UsuarioDLL.listaUsuarios();
        }catch(Exception e){
            FacesMessage m=new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, m);
        }
    }
}
