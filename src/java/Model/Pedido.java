/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Tipo.TipoPago;
import java.sql.Date;
import java.util.LinkedList;

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
    private LinkedList<Producto> productos=new LinkedList<>();
    private String Estado;

    public Pedido() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public Date getFechaEmitida() {
        return fechaEmitida;
    }

    public void setFechaEmitida(Date fechaEmitida) {
        this.fechaEmitida = fechaEmitida;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public String getTipoDspacho() {
        return tipoDspacho;
    }

    public void setTipoDspacho(String tipoDspacho) {
        this.tipoDspacho = tipoDspacho;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
    
    
    
    
}
