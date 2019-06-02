package com.avbravo.webtestreport.entity;

import com.avbravo.jmoordb.anotations.Id;


public class Grupo{

    @Id
    private Integer idgrupo;
    private String descripcion;
    
    private String activo;


    public Grupo() {
    }

    public Grupo(Integer idgrupo, String descripcion, String activo) {
        this.idgrupo = idgrupo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

  
    
    
    @Override
    public String toString() {
        return  descripcion ;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    

}
