/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tipo;

import DAO.Conexion.SNMPExceptions;
import DAO.TipoUsuarioDLL;

/**
 *
 * @author Usuario
 */
public class TipoUsuario {
    private int id;
    private String Descripcion;
    
    
    
    public TipoUsuario(int id, String TipoU){
    this.id=id;
    this.Descripcion=TipoU;
    }
    
    public TipoUsuario(){
    this.id=0;
    this.Descripcion="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
    
    public TipoUsuario traerTipo(String d) throws SNMPExceptions{
    return TipoUsuarioDLL.traerTipoUsuarioPorDescripcion(d);
    
    }
    
    
    
    
    
    
    
    
    
    
}
