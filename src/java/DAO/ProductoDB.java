/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import Model.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Jesus
 */
public class ProductoDB {

    public static void AgregarProducto(Producto pro) throws SNMPExceptions{
         String Insert = "exec InsertarProductos '"
                  +pro.getNombre()+"','"
                  +pro.getDescripcion()+"','"
                  +pro.getFoto()+"',"
                  +pro.getPrecio()+","
                  +pro.getCantidadMinimaVenta();
        
   
        

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

           //se valida que no exista el producto
       if(existeProducto(pro.getId())){
           //se construye sentencia update
           String update="exec ActualizarProductos "+pro.getId()+",'"
                   +pro.getNombre()+"','"
                  +pro.getDescripcion()+"','"
                  +pro.getFoto()+"',"
                  +pro.getPrecio()+","
                  +pro.getCantidadMinimaVenta();
             //Se ejecuta la sentencia SQL
      accesoDatos.ejecutaSQL(update); 
       }
       else{
            //Se ejecuta la sentencia SQL
      accesoDatos.ejecutaSQL(Insert); 
       }
          
  
         
         

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        }
    }
    
    public static LinkedList<Producto> listaProductos() throws SNMPExceptions{
        String select = "exec SeleccionarProductos";
        LinkedList<Producto> listaProductos = new LinkedList<Producto>();

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();
            

            //Se crea la sentencia de búsqueda
         
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
                Producto pro=new Producto();
                 pro.setEstado(rsPA.getInt("estado")==1);
                 if(pro.isEstado()){
                pro.setId(rsPA.getInt("id"));
                pro.setNombre(rsPA.getString("nombre"));
                pro.setDescripcion(rsPA.getString("descripcion"));
               pro.setFoto(rsPA.getString("foto"));
                pro.setPrecio(rsPA.getFloat("precio"));
                pro.setCantidadMinimaVenta(rsPA.getInt("cantidadMinimaVenta")); 
                listaProductos.add(pro);
                 }

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
        return listaProductos;
    }

private static boolean existeProducto(int id) throws SNMPExceptions{
 String select = "exec SeleccionarProductoXid " +id;
        boolean resultado=false;

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();
            

            //Se crea la sentencia de búsqueda
         
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
                resultado=true;
          

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
        return resultado;
}
    public static void EliminarProducto(Producto pro) throws SNMPExceptions{
         String DELETE = "exec elminarProducto "+pro.getId();
               
        
   
        

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

           //se valida que no exista el producto
      
            //Se ejecuta la sentencia SQL
      accesoDatos.ejecutaSQL(DELETE); 
                 
  
         
         

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        }
    }
    
}