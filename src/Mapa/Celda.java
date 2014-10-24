/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Items.Objeto;
import java.util.ArrayList;

public class Celda {
   
    private final String descripcion;
    private final ArrayList<Objeto> items;
    private final boolean transitable;
    private final boolean esInicio;
    private final boolean esFin;
    
    // Constructor    
    public Celda(){
        
        this.descripcion = "Unknown";
        this.items = new ArrayList<>();
        this.transitable = true;
        this.esInicio = false;
        this.esFin = false;
        
    }

    // Metodo para imprimir
    @Override
    public String toString() {
        if(transitable)
        return "*";
        else
        return ".";
    }    
    
}
