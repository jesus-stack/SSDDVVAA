
/*
 * To change this license header, choose License Headers in Project Propert

* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import Model.Cliente;
import Model.Tipo.TipoUsuario;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Usuario
 */
public class UsuarioDLL {
    
    
    
 public static int insertarUsuario(Usuario usuario) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
 String procedure1="insert into usuario (id) values ("+usuario.getId()+")";
     AccesoDatos datos=new AccesoDatos();
     return datos.ejecutaSQL(procedure1);
 
 
 }
 
 
 
 
 public static void insertarCliente(Cliente cliente) throws NamingException, SNMPExceptions, SQLException, ClassNotFoundException{
     
 cliente.setTipo(TipoUsuarioDLL.traerTipoUsuarioPorDescripcion("Cliente"));

 String procedure="exec InsertarCliente "+((Cliente)cliente).getIdentificacion()+", '"+((Cliente)cliente).getNombre()+"', '"+((Cliente)cliente).getSegundoNombre()+"', '"
        +((Cliente)cliente).getApellido()+"', '"+((Cliente)cliente).getSegundoApellido()+"', '"+((Cliente)cliente).getCorreo()+"', "+((Cliente)cliente).getTelefono()+
         ", '"+((Cliente)cliente).getContrasenna()+"', "+((Cliente)cliente).getTipo().getId();
 
 
 AccesoDatos datos=new AccesoDatos();
   datos.ejecutaSQL(procedure);

 
 }
    
 
 
 //tipos de usuarios
 public static LinkedList<TipoUsuario> listaTipoUsuario() throws SNMPExceptions{
    String select = "";
        LinkedList<TipoUsuario> listaEstado = new LinkedList<TipoUsuario>();

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "exec SeleccionarTiposUsuario";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int id = rsPA.getInt("id");
                String descr = rsPA.getString(""
                        + "descripcion");

                listaEstado.add(new TipoUsuario(id, descr));
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
        return listaEstado;
    }
    
 
     public static Usuario UsuarioXidentificacion(long id) throws SNMPExceptions{
    String select = "exec SeleccionaUsuarioXIdentificacion "+id;
        Usuario usuario = new Usuario();

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
         
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos 
             while (rsPA.next()) {
            usuario.setId(rsPA.getLong("id"));
            usuario.setContrasenna(rsPA.getString("contrasenna"));
            usuario.setTipo(new TipoUsuario(rsPA.getInt("tipoUsuario"),"usuario"));
            usuario.setEstado((rsPA.getInt("estado")==1));
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
        return usuario;
    } 
     
     
     
     
 
 } 
 
 
    
    
