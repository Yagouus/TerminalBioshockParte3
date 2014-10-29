
package MainCharacter;

import Mapa.Celda;
import Mapa.Mapa;
import java.awt.Point;
import java.util.ArrayList;

public class Personaje {
    
    private String Nombre;
    private Integer vida;
    private Integer energia;
    private Integer pasos;
    private Mochila mochila;
    private Point posicion;
    private ArrayList<Celda> recorrido;
    private Mapa mapa;
    private Acciones accionesPersonaje;
    
    public Personaje(Mapa mapa){
        
        this.Nombre = "Unknown";
        this.vida = 100;
        this.energia = 100;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.recorrido = new ArrayList<>();
        this.posicion = mapa.getInicio();
        
    }
    
    public Personaje(Mapa mapa, String Nombre, Integer vida, Integer energia){
        
        this.Nombre = Nombre;
        this.vida = vida;
        this.energia = energia;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.posicion = mapa.getInicio();
        this.recorrido = new ArrayList<>();
  
        
    }    

    public String getNombre() {
        return Nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getEnergia() {
        return energia;
    }

    public Integer getPasos() {
        return pasos;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public Point getPosicion() {
        return posicion;
    }

    public ArrayList<Celda> getRecorrido() {
        return recorrido;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Acciones getAccionesPersonaje() {
        return accionesPersonaje;
    }
    
}
