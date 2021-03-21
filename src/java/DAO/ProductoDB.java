/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Conexion.AccesoDatos;
import DAO.Conexion.SNMPExceptions;
import Model.Producto;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jesus
 */
public class ProductoDB {

    public static void AgregarProducto(Producto pro,InputStream input) throws SNMPExceptions{
         String Insert = "exec InsertarProductos '"
                  +pro.getNombre()+"','"
                  +pro.getDescripcion()+"','"
                  +input+"',"
                  +pro.getPrecio()+","
                  +pro.getCantidadMinimaVenta();
    
        

        try {
        
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
         
            //Se ejecuta la sentencia SQL
      accesoDatos.ejecutaSQL(Insert);
  
         
         

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
                pro.setNombre(rsPA.getString("nombre"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                pro.setFoto(rsPA.getBytes("foto"));
                pro.setPrecio(rsPA.getFloat("precio"));
                pro.setCantidadMinimaVenta(rsPA.getInt("cantidadMinimaVenta"));
                listaProductos.add(pro);

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
}
