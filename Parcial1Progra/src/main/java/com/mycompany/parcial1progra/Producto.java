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
public class Producto {
    
    private Scanner tienda = new Scanner(System.in);
    private String Producto;
    private int cantidad;
    private Double Garantia;
    
    private Double PesoProduc;
    
    
    public void CargadeDatos(){
        System.out.println("Ingrese el nombre de su Producto: ");
        setProducto(getA().nextLine());
        System.out.println("Ingrese la  cantidad del Producto: ");
        setCantidad(getA().nextInt());
        getA().nextLine();
        System.out.println("Ingrese la Garantia: ");
        setGarantia(Double.valueOf(getA().nextLine()));
        System.out.println("Ingrese el peso del producto: ");
        setPesoProduc(Double.valueOf(getA().nextLine()));
      
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
     * @return the Producto
     */
    public String getProducto() {
        return Producto;
    }

    /**
     * @param Producto the Producto to set
     */
    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the Garantia
     */
    public Double getGarantia() {
        return Garantia;
    }

    /**
     * @param Garantia the Garantia to set
     */
    public void setGarantia(Double Garantia) {
        this.Garantia = Garantia;
    }

    /**
     * @return the PesoProduc
     */
    public Double getPesoProduc() {
        return PesoProduc ;
    }

    /**
     * @param PesoProduc the Pesoproduc to set
     */
    public void setPesoProduc(Double PesoProduc) {
        this.PesoProduc = PesoProduc;
    }

    public void recolectarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

    

