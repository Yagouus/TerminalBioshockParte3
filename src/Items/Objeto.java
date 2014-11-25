package Items;

import java.awt.Point;

public class Objeto {

    String nombre;
    String tipo;
    Float peso;
    Integer efecto;
    Point posicion;
    String descripcion;
    String modificador;
    String propietario;
    

    public Objeto() {

        nombre = "Unknown";
        tipo = "Unknown";
        peso = 0f;
        efecto = 0;

    }

    public Objeto(String nombre, String tipo, Float peso, Integer efecto) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.efecto = efecto;

    }
    
    public Objeto (Point punto,String propietario, String tipo, String nombre, String descripcion, String modificador, Integer efecto, Float peso){
        
        this.posicion = punto;
        this.propietario = propietario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificador = modificador;
        this.efecto = efecto;
        this.peso = peso;
        
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Float getPeso() {
        return peso;
    }

    public Integer getEfecto() {
        return efecto;
    }
    
    public Point getPosicion(){
        return this.posicion;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
   
    
    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setEfecto(Integer efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

}
