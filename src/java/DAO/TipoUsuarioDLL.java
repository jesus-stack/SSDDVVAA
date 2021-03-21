
package DAO;

import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import Model.Tipo.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class TipoUsuarioDLL {
    
    
    
    
    public static TipoUsuario traerTipoUsuarioPorDescripcion(String des) throws SNMPExceptions{
    
      String select = "";
      TipoUsuario tipo=new TipoUsuario();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "exec TraerTipoUsuario '"+des+"'";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int id = rsPA.getInt("id");
                String descr = rsPA.getString(""
                        + "Descripcion");

               tipo.setId(id);
               tipo.setDescripcion(descr);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return tipo;
    
    
    
    
    
    }

    
    
    
    
    
    
    
    
    
    
    
}
