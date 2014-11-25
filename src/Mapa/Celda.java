package Mapa;

import Items.Objeto;
import MainCharacter.Personaje;
import java.util.ArrayList;

public class Celda {

    private String descripcion;
    private ArrayList<Objeto> items;
    private ArrayList<Personaje> NPCS;
    private boolean transitable;
    private boolean visible;
    private boolean esInicio;
    private boolean esFin;
    private String tipo;

    // Constructor    
    public Celda() {

        this.descripcion = "Unknown";
        this.items = new ArrayList<>();
        this.NPCS = new ArrayList<>();
        this.transitable = false;
        this.visible = false;
        this.esInicio = false;
        this.esFin = false;

    }

    public Celda(String descripcion, ArrayList<Objeto> items, boolean transitable, boolean esInicio, boolean esFin) {

        this.descripcion = "Unknown";
        this.items = new ArrayList<>();
        this.NPCS = new ArrayList<>();
        this.transitable = false;
        this.visible = false;
        this.esInicio = false;
        this.esFin = false;

    }

    public Celda(String tipo, String descripcion) {

        this.descripcion = descripcion;
        this.tipo = tipo;
        this.items = new ArrayList<>();
        this.NPCS = new ArrayList<>();
        this.transitable = true;
        this.visible = false;
        this.esFin = false;

    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public ArrayList<Objeto> getItems() {
        return items;
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

    public boolean isVisible() {
        return this.visible;
    }

    public ArrayList<Personaje> getNPCS() {

        return this.NPCS;

    }


    // Setters    
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

    public void setVisible() {
        this.visible = true;
    }

    public void añadirPersonaje(Personaje personaje) {

        this.NPCS.add(personaje);

    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.NPCS = personajes;
    }

    // Metodo para imprimir
    @Override
    public String toString() {
        if (transitable) {
            return " ";
        } else {
            return "X";
        }

    }

}
