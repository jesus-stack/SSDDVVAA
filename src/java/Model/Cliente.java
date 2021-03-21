/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Tipo.TipoUsuario;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cliente extends Usuario {

    private long identificacion;
    private String nombre, SegundoNombre, apellido, SegundoApellido, correo;
    private int telefono;
    private ArrayList<Direccion> ArrayDireccione=new ArrayList<Direccion>();
   
  
    public Cliente(long id, String nombre, String sNombre, String apellido, String sApellido, String correo, int telefono,String clave,boolean estado,TipoUsuario tipo) {
        super(id, clave, estado, tipo);
        this.identificacion = id;
        this.nombre = nombre;
        this.SegundoNombre = sNombre;
        this.apellido = apellido;
        this.SegundoApellido = sApellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Cliente(){
       super();
        this.identificacion=0;
        this.nombre = "";
        this.SegundoNombre = "";
        this.apellido = "";
        this.SegundoApellido = "";
        this.correo = "";
        this.telefono = 0;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public ArrayList<Direccion> getArrayDireccione() {
        return ArrayDireccione;
    }

    public void setArrayDireccione(ArrayList<Direccion> ArrayDireccione) {
        this.ArrayDireccione = ArrayDireccione;
    }
    
    

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
