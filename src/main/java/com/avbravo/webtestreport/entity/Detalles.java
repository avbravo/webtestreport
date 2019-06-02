/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.webtestreport.entity;

import com.avbravo.jmoordb.anotations.Id;

/**
 *
 * @author avbravo
 */

public class Detalles {
    @Id
    private Integer idproducto;
    private String producto;

    public Detalles() {
    }


    public Detalles(Integer idproducto, String producto) {
        this.idproducto = idproducto;
        this.producto = producto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
    
}
