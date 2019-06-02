/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.webtestreport.entity;

import com.avbravo.jmoordb.anotations.Embedded;
import com.avbravo.jmoordb.anotations.Id;
import java.util.List;

/**
 *
 * @author avbravo
 */

public class Facturas {
    @Id
    private Integer idfactura;
    private String cliente;
    @Embedded
    private List<Detalles> detalles;

    public Facturas() {
    }

    public Facturas(Integer idfactura, String cliente, List<Detalles> detalles) {
        this.idfactura = idfactura;
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Detalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }
    
    
    
    
}
