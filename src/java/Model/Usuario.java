/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Tipo.TipoUsuario;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private long id;
    private String contrasenna;
    private boolean estado;
    private TipoUsuario tipo;

    
    public Usuario(long id,String clave,boolean estado,TipoUsuario tipo){
    this.id=id;
    this.contrasenna=clave;
    this.estado=estado;
    this.tipo=tipo;
    }
    
    
    public Usuario(){
     this.id=0;
    this.contrasenna="";
    this.estado=true;
    this.tipo=null;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
