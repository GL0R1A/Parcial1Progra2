/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial;

import com.mycompany.parcial1progra.Producto;
import com.mycompany.parcial1progra.ProrrateodeFacturas;
import java.util.Scanner;

/**
 *
 * @author STEFANNIE FLANDEZ
 */
public class ClsPrincipal {

    
    private static Scanner t = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Cuantos productos desea agregar?");
        int num = t.nextInt();
        t.nextLine();
        ProrrateodeFacturas prorrateo = new ProrrateodeFacturas(num);
        ClsCostosdeequipo gastos = new ClsCostosdeequipo();
        for (int i = 0; i < num; i++) {
            Producto producto = new Producto();
            producto.recolectarInformacion();
            prorrateo.agregaVendedorMatriz(producto);
        }
        
        gastos.recolectarInformacion();
        prorrateo.agregaGastos(gastos);
        ProrrateodeFacturas.ejecutar();
    }
}

    


    
    

    

   