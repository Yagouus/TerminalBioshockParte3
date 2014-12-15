package Items;

import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionUsar;
import Personajes.Personaje;
import java.awt.Point;

public class Objeto {

    protected String nombre;
    protected Float peso;
    protected Integer efecto;
    protected Point posicion;
    protected String descripcion;
    protected String propietario;

    public Objeto() {

        nombre = "Unknown";
        peso = 0f;
        efecto = 0;

    }

    public Objeto(String nombre, String tipo, Float peso, Integer efecto) {

        this.nombre = nombre;
        this.peso = peso;
        this.efecto = efecto;

    }

    public Objeto(Point punto, String propietario, String nombre, String descripcion, Integer efecto, Float peso) {

        this.posicion = punto;
        this.propietario = propietario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.efecto = efecto;
        this.peso = peso;

    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Float getPeso() {
        return peso;
    }

    public Integer getEfecto() {
        return efecto;
    }

    public Point getPosicion() {
        return this.posicion;
    }

    public String getDescripcion() {
        return this.descripcion;
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

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setEfecto(Integer efecto) {
        this.efecto = efecto;
    }

    //Acciones
    //METODO ABSTRACTO
    public void Usar(Personaje personaje) throws ExcepcionJuego, ExcepcionUsar {
        
        throw new ExcepcionUsar();

    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

}
