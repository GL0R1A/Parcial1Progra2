/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcial1progra;


import com.parcial.ClsPrincipal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author STEFANNIE FLANDEZ
 */
public class ProrrateodeFacturas {
    
    private static String[][] prorrateofacturas = new String[1][1];
    private static Double[] costos = new Double[1];
    private static Double[] Productos = new Double[1];
    public static NumberFormat formatoCantidad = NumberFormat.getCurrencyInstance(new Locale("es","GT"));
    
    private static final int CANTIDAD = 0;
    private static final int Producto = 1;
    private static final int VALOR = 2;
    private static final int GASTO_Garantia = 3;
    private static final int GASTO_PesoProduct = 4;
    private static final int Valor_Unico = 5;
    private static final int Costo_total = 6;
    private final int MAX_COLUMNAS = 7;
    
    private int filaActual = 0;
    
    public ProrrateodeFacturas(int filas){
        prorrateofacturas = new String[filas][MAX_COLUMNAS];
        Productos = new Double[filas];
        costos = new Double[5];
    }
    
    public static String cambioform(String cantidad){
        Double nuevaCantidad = Double.parseDouble(cantidad);
        return formatoCantidad.format(nuevaCantidad);
    }
    
    public static void imprimirDecorado(){
        for (int x = 0; x < prorrateofacturas.length; x++) { 
            System.out.print("|");
            for (int y = 0; y < prorrateofacturas[x].length; y++) {
                if (y > 1){
                    System.out.print(cambioform(prorrateofacturas[x][y]));
                }
                else{
                    System.out.print(prorrateofacturas[x][y]);
                }
                if (y != prorrateofacturas[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
    
    public static Double valorTotal(){
        Double total = 0.0;
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            total += (Double.valueOf(prorrateofacturas[fila][VALOR])*Double.valueOf(prorrateofacturas[fila][CANTIDAD]));
        }
        return total;
    }
    
    public static Double sumarArreglo(int inicio){
        Double total = 0.0;
        for (int i = inicio; i < costos.length; i+=2) {
            total += costos[i];
        }
        return total;
    }
    
    public static void gastosValor(Double coeficiente){
        for (int i = 0; i < prorrateofacturas.length; i++) {
            prorrateofacturas[i][GASTO_Garantia] = (Double.valueOf(prorrateofacturas[i][VALOR])*coeficiente) + "";
        }
    }
    
    public static Double pesoTotal(){
        Double total = 0.0;
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            total += (Double.valueOf(prorrateofacturas[fila][CANTIDAD])*Productos[fila]);
        }
        return total;
    }
    
    public static Double totalGastoPeso(){
        Double total = 0.0;
        for (int i = 1; i < costos.length; i+=2) {
             total += Double.valueOf(costos[i]);
        }
        return total;
    }
    
    public static void gastosPeso(Double coeficiente){
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            prorrateofacturas[fila][GASTO_PesoProduct] = (Productos[fila]*coeficiente) + "";
        }
    }
    
    public static void calculoCostoUnitario(){
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            prorrateofacturas[fila][Valor_Unico] = (Double.valueOf(prorrateofacturas[fila][VALOR])
                                            +Double.valueOf(prorrateofacturas[fila][GASTO_Garantia])
                                            +Double.valueOf(prorrateofacturas[fila][GASTO_PesoProduct])) + "";
        }
    }
    
    public static void calculoCostoTotal(){
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            prorrateofacturas[fila][Costo_total] = (Double.valueOf(prorrateofacturas[fila][Valor_Unico])
                                           *Double.valueOf(prorrateofacturas[fila][CANTIDAD])) + "";
        }
    }
    
    public static Double totalCuadro(){
        Double total = 0.0;
        for (int fila = 0; fila < prorrateofacturas.length; fila++) {
            total += Double.valueOf(prorrateofacturas[fila][Costo_total]);
        }
        return total;
    }
    
    public static String Validacion(Double a, Double b){
        Double diferencia = Math.abs(a - b);
        if (diferencia <= 0.20){
            return "El ejercicio se ha resuelto correctamenta.";
        }
        else {
            return "Hay un error en ejercicio, los totales no coinciden.";
        }
    }
    
    public static void ejecutar(){
        //Paso 1
        Double valorTotal = valorTotal();
        //Paso 2
        Double totalGastoValor = sumarArreglo(0);
        //Paso 3
        Double coeficienteGasto = totalGastoValor/valorTotal;
        //Paso 4
        gastosValor(coeficienteGasto);
        //Paso 5
        Double pesoTotal = pesoTotal();
        //Paso 6
        Double totalGastoPeso = sumarArreglo(1);
        //Paso 7
        Double coeficienteGastoPeso = totalGastoPeso/pesoTotal;
        //Paso 8
        gastosPeso(coeficienteGastoPeso);
        //Paso 9
        calculoCostoUnitario();
        calculoCostoTotal();
        imprimirDecorado();
        //Paso 10
        Double totalCuadro = totalCuadro();
        Double granTotal = valorTotal + totalGastoValor + totalGastoPeso;
        String resultado = Validacion(totalCuadro, granTotal);
        System.out.println("El resultado es: " + resultado);
    }
    
    public String agregaVendedorMatriz(Producto producto){
        if (filaActual >= prorrateofacturas.length){
            return "Limite de filas alcanzado.";
        }
        else{
            prorrateofacturas[filaActual][Producto] = producto.getProducto();
            prorrateofacturas[filaActual][CANTIDAD] = producto.getCantidad() + "";
            prorrateofacturas[filaActual][VALOR] = producto.getGarantia() + "";
            Productos[filaActual] = producto.getPesoProduc();
            filaActual++;
        }
        return "OK!";
    }
    
    public void añadirCostos(ClsCostosdeequipos objGastos){
        costos[0] = objGastos.getMercancia();
        costos[1] = objGastos.getFlete();
        costos[2] = objGastos.getServicios();
        costos[3] = objGastos.getTransporte();
      
    }

   

   
}

   

