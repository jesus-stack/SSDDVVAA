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
public class Funcionario extends Usuario {
    
    private long identificacion;
    private String nombre, sNombre, apellido, sApellido, correo;
    private int telefono;
    
    public Funcionario(long id, String clave, boolean estado, TipoUsuario tipo,String nombre, String sNombre, String apellido, String sApellido, String correo, int telefono) {
        super(id, clave, estado, tipo);
        this.identificacion=id;
        this.nombre=nombre;
        this.sNombre=sNombre;
        this.apellido=apellido;
        this.sApellido=sApellido;
        this.correo=correo;
        this.telefono=telefono;
    }

    public Funcionario() {
       super();
        this.identificacion=0;
        this.nombre="";
        this.sNombre="";
        this.apellido="";
        this.sApellido="";
        this.correo="";
        this.telefono=0;   
    }
    
    
    
    
   
}
