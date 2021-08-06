/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcial1progra;

import java.util.Scanner;


        

/**
 *
 * @author STEFANNIE FLANDEZ
 */
public class ClsCostosdeequipos {

    
  
    private Scanner tienda = new Scanner(System.in);
    private Double mercancia;
    private Double flete;
    private Double servicios;
    private Double transporte;
   
    
    public void añadirInformacion(){
        System.out.println("mercancia: ");
        setMercancia(Double.valueOf(getA().nextLine()));
        System.out.println("flete: ");
        setFlete(Double.valueOf(getA().nextLine()));
        System.out.println("servicios: ");
        setServicios(Double.valueOf(getA().nextLine()));
        System.out.println("transporte: ");
        setTransporte(Double.valueOf(getA().nextLine()));
        
    }

    /**
     * @return the tienda
     */
    public Scanner getA() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setA(Scanner tienda) {
        this.tienda = tienda;
    }

    /**
     * @return the Mercancia
     */
    public Double getMercancia() {
        return mercancia;
    }

    /**
     * @param Mercancia the Mercancia to set
     */
    public void setMercancia(Double Mercancia) {
        this.mercancia = Mercancia;
        
    }

    /**
     * @return the flete
     */
    public Double getFlete() {
        return flete;
    }

    /**
     * @param flete the flete to set
     */
    public void setFlete(Double flete) {
        this.flete = flete;
    }

    /**
     * @return the aduana
     */
    public Double getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(Double servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the transporte
     */
    public Double getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(Double transporte) {
        this.transporte = transporte;
    }
}
    

   