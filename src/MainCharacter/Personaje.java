package MainCharacter;

import Items.Objeto;
import Mapa.Mapa;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Personaje {

    private String Nombre;
    private String tipo;
    private Integer vida;
    private Integer energia;
    private Integer fuerza;
    private Integer defensa;
    private Integer pasos;
    private Mochila mochila;
    private String frase;
    private Point posicion;
    private ArrayList<String> recorrido;
    private ArrayList<Point> movimientos;
    private Mapa mapa;
    private Acciones accionesPersonaje;

    public Personaje(Mapa mapa) {

        this.Nombre = "Unknown";
        this.tipo = "Unknown";
        this.vida = 5;
        this.energia = 100;
        this.fuerza = 10;
        this.defensa = 7;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.posicion = mapa.getInicio();
        this.accionesPersonaje = new Acciones();

    }

    public Personaje(Point punto, String nombre, String tipo, Integer vida, Integer energia, Integer fuerza, Integer defensa, String frase) {
        this.posicion = punto;
        this.Nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.energia = energia;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.frase = frase;

    }

    public Personaje(Mapa mapa, String Nombre, Integer vida, Integer energia, Integer Fuerza, Integer Defensa, String tipo) {

        this.Nombre = Nombre;
        this.vida = vida;
        this.energia = energia;
        this.fuerza = Fuerza;
        this.defensa = Defensa;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.posicion = mapa.getInicio();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.accionesPersonaje = new Acciones();
        this.tipo = tipo;

    }

    public Personaje() {

        this.Nombre = "Unknown";
        this.tipo = "Unknown";
        this.vida = 5;
        this.energia = 100;
        this.fuerza = 10;
        this.defensa = 7;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.accionesPersonaje = new Acciones();
    }

    // Getters
    public String getNombre() {
        return Nombre;
    }

    public Integer getVida() {
        return this.vida;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public Integer getEnergia() {
        return energia;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public ArrayList<Point> getMovimientos() {
        return movimientos;
    }

    public Integer getPasos() {
        return pasos;
    }

    public Point getPosicion() {
        return posicion;
    }

    public ArrayList<String> getRecorrido() {
        return recorrido;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Acciones getAccionesPersonaje() {
        return accionesPersonaje;
    }
    
    public String getTipo(){
        return this.tipo;
    }
 

    // Setters
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setVida(Integer vida) {

        if (vida < 0 || vida > 100) {
            System.out.println("Parametro Invalido");
        }
        if (this.vida < 0) {
            this.vida = 0;
        }
        this.vida = vida;
    }

    public void setEnergia(Integer energia) {
        if (energia < 0 || energia > 100) {
            System.out.println("Parametro Invalido");
        }
        if (this.energia < 0) {
            this.energia = 0;
        }
        this.energia = energia;
    }

    public void setPasos(Integer pasos) {
        this.pasos = pasos;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public void setMovimientos(ArrayList<Point> movimientos) {
        this.movimientos = movimientos;
    }

    public void setMovimientos(Point celda) {
        this.movimientos.add(celda);
    }

    public void setRecorrido(ArrayList<String> recorrido) {
        this.recorrido = recorrido;
    }

    public void setRecorrido(String direccion) {
        this.recorrido.add(direccion);
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
    
    public void setTipo(String tipo){
        
        this.tipo = tipo;
    }
    
    public void setFuerza(Integer fuerza){
        this.fuerza = fuerza;
    }
    
    public void setDefensa(Integer defensa){
        this.defensa = defensa;
    }

    // Metodos propios    

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    public void anadirMochila(Objeto objeto){
        
        this.mochila.setContenido(objeto);
        this.mochila.actualizarPeso();
        
    }
   

    @Override
    public String toString() {
        return "NOMBRE:" + this.getNombre() + " VIDA:" + this.getVida() + " ENERGIA:" + this.getEnergia();//To change body of generated methods, choose Tools | Templates.
    }

}
