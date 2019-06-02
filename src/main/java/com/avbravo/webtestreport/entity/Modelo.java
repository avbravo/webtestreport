package com.avbravo.webtestreport.entity;


import com.avbravo.jmoordb.anotations.Id;
import com.avbravo.jmoordb.anotations.Referenced;


public class Modelo {

    @Id
    private Integer idmodelo;
    private String descripcion;
    @Referenced(documment = "Grupoarticulo", repository = "com.avbravo.webtestreport.repository.GrupoRepository",
            field = "idgrupo",javatype = "Integer",lazy = false)
    private Grupo grupo;
    private Integer cantidad;



    public Modelo() {
    }

    public Modelo(Integer idmodelo, String descripcion, Grupo grupo, Integer cantidad) {
        this.idmodelo = idmodelo;
        this.descripcion = descripcion;
        this.grupo = grupo;
        this.cantidad = cantidad;
    }

    

    @Override
    public String toString() {
        return descripcion ;
    }

    public Integer getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Integer idmodelo) {
        this.idmodelo = idmodelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
