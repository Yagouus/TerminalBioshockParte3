
package Mapa;

import Items.Objeto;
import java.awt.Point;
import java.util.ArrayList;

public class Celda {

    private  String descripcion;
    private  ArrayList<Objeto> items;
    private  boolean personaje;
    private  boolean transitable;
    private  boolean esInicio;
    private  boolean esFin;

    // Constructor    
    public Celda() {

        this.descripcion = "Unknown";
        this.items = new ArrayList<>();
        this.transitable = false;
        this.esInicio = false;
        this.esFin = false;
        this.personaje = false;

    }
    
    public Celda(String descripcion, ArrayList<Objeto> items, boolean personaje, boolean transitable, boolean esInicio, boolean esFin) {

        this.descripcion = "Unknown";
        this.items = new ArrayList<>();
        this.transitable = false;
        this.esInicio = false;
        this.esFin = false;
        this.personaje = false;

    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Objeto> getItems() {
        return items;
    }

    public boolean isPersonaje() {
        return personaje;
    }

    public boolean isTransitable() {
        return transitable;
    }

    public boolean isEsInicio() {
        return esInicio;
    }

    public boolean isEsFin() {
        return esFin;
    }

    // Setters
    public void setPersonaje() {
        this.personaje = true;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTransitable(boolean transitable) {
        this.transitable = transitable;
    }

    public void setEsInicio() {
        this.esInicio = true;
    }

    public void setEsFin() {
        this.esFin = true;
    }

    // Metodo para imprimir
    @Override
    public String toString() {
        if (transitable) 
            return " ";
         else 
            return "X";
        
    }

}
