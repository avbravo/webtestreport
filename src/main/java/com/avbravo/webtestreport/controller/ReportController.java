/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.webtestreport.controller;

// <editor-fold defaultstate="collapsed" desc="imports">
import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.jmoordbutils.printer.Printer;
import com.avbravo.webtestreport.entity.Detalles;
import com.avbravo.webtestreport.entity.Facturas;
import com.avbravo.webtestreport.entity.Grupo;
import com.avbravo.webtestreport.entity.Modelo;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;
// </editor-fold>

/**
 *
 * @authoravbravo
 */
@Named
@ViewScoped
public class ReportController implements Serializable {
// <editor-fold defaultstate="collapsed" desc="fields">  

    private static final long serialVersionUID = 1L;

    List<Grupo> grupoList = new ArrayList<>();
    Grupo grupo1;
    Grupo grupo2;
    Grupo grupo3;
    Grupo grupo4;

    List<Modelo> modeloList = new ArrayList<>();
    Modelo modelo1;
    Modelo modelo2;
    Modelo modelo3;

    @Inject
    Printer printer;

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="constructor">
    public ReportController() {
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        //grupo
        grupo1 = new Grupo(1, "Laptop", "si");
        grupo2 = new Grupo(2, "Server", "si");
        grupo3 = new Grupo(3, "Mouse", "si");
        grupo4 = new Grupo(4, "Monitor", "si");

        //modelo
        modelo1 = new Modelo(1, "HP", grupo1, 5);
        modelo2 = new Modelo(2, "Samsung", grupo1, 63);
        modelo3 = new Modelo(3, "Maxell", grupo3, 40);
//grupo
        grupoList.add(grupo1);
        grupoList.add(grupo2);
        grupoList.add(grupo3);
        grupoList.add(grupo4);

//modelo
        modeloList.add(modelo1);
        modeloList.add(modelo2);
        modeloList.add(modelo3);

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="printGrupoDetails()">

    public String printGrupoDetails() {
        try {
            List<Grupo> list = new ArrayList<>();
            list.add(grupo1);
            String ruta = "/resources/reportes/grupo/details.jasper";
            HashMap parameters = new HashMap();
            parameters.put("P_EMPRESA", "WizardReport");
            printer.imprimir(list, ruta, parameters);
        } catch (Exception ex) {
            JsfUtil.errorMessage("printGrupoDetails() " + ex.getLocalizedMessage());
        }
        return null;
    }// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="printGrupoAll()">

    public String printGrupoAll() {

        try {
            String ruta = "/resources/reportes/grupo/all.jasper";
            HashMap parameters = new HashMap();
            parameters.put("P_EMPRESA", "WizardReport");
            printer.imprimir(grupoList, ruta, parameters);
        } catch (Exception ex) {
            JsfUtil.errorMessage("printGrupoAll() " + ex.getLocalizedMessage());
        }
        return null;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="printModeloDetails()">

    public String printModeloDetails() {
        try {
            List<Modelo> list = new ArrayList<>();
            list.add(modelo1);
            String ruta = "/resources/reportes/modelo/details.jasper";
            HashMap parameters = new HashMap();
            parameters.put("P_EMPRESA", "WizardReport");
            printer.imprimir(list, ruta, parameters);
        } catch (Exception ex) {
            JsfUtil.errorMessage("printModeloDetails() " + ex.getLocalizedMessage());
        }
        return null;
    }// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="printModeloAll(">

    public String printModeloAll() {

        try {
            String ruta = "/resources/reportes/modelo/all.jasper";
            HashMap parameters = new HashMap();
            parameters.put("P_EMPRESA", "WizardReport");
            printer.imprimir(modeloList, ruta, parameters);
        } catch (Exception ex) {
            JsfUtil.errorMessage("printModeloAll() " + ex.getLocalizedMessage());
        }
        return null;
    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="printFacturaSubReport()">
    public String printFacturaSubReport() {

        try {
            List<Facturas> facturasList = new ArrayList<Facturas>();
            List<Detalles> detallesList = new ArrayList<>();

            detallesList.add(new Detalles(10, "Impresora"));
            detallesList.add(new Detalles(20, "Disco Duro"));
            facturasList.add(new Facturas(1, "Juana Bosquez", detallesList));

            //
            detallesList = new ArrayList<>();
            detallesList.add(new Detalles(30, "Memoria RAM"));
            facturasList.add(new Facturas(25, "Luris Bares", detallesList));

            String ruta = "/resources/reportes/facturas/facturas_master.jasper";
            HashMap parameters = new HashMap();

            printer.imprimir(facturasList, ruta, parameters);
//            String reportsDirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reportes/facturas/");
            String reportsDirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reportes/facturas");
//          reportsDirPath += "/";
            reportsDirPath += "/detalles_subreport.jasper";
//            parameters.put("SUBREPORT_DIR", reportsDirPath + "/detalles_subreport");
            parameters.put("SUBREPORT_DIR", reportsDirPath);
            parameters.put("P_EMPRESA", "WizardReport");

            printer.imprimir(facturasList, ruta, parameters);

        } catch (Exception ex) {
            JsfUtil.errorMessage("printFacturaSubReport() " + ex.getLocalizedMessage());
        }
        return null;
    }// </editor-fold>

}
