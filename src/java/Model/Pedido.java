/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Tipo.TipoPago;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private int id;
    private Cliente cliente;
    private Date fechaSolicitada;
    private Date fechaEmitida;
    private float costoEnvio;
    private TipoPago tipoPago;
    private float Descuento;
    private String tipoDspacho;
    private float subTotal;
    private float total;
    private boolean Estado;
    
    
    
    
    
    
    
}
