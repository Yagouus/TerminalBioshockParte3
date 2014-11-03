package MainCharacter;


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
    private ArrayList<String> recorrido;
    private ArrayList<Point> movimientos;
    private Mapa mapa;
    private String life;
    private Acciones accionesPersonaje;

    public Personaje(Mapa mapa) {

        this.Nombre = "Unknown";
        this.vida = 5;
        this.energia = 100;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.posicion = mapa.getInicio();
        this.accionesPersonaje = new Acciones();


    }

    public Personaje(Mapa mapa, String Nombre, Integer vida, Integer energia) {

        this.Nombre = Nombre;
        this.vida = vida;
        this.energia = energia;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.mapa = mapa;
        this.posicion = mapa.getInicio();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.accionesPersonaje = new Acciones();
  

    }

    // Getters
    public String getNombre() {
        return Nombre;
    }

    public String getVida() {

        switch (vida) {
            case 5:
                this.life = "♥♥♥♥♥";
                break;
            case 4:
                this.life = "♥♥♥♥";
                break;
            case 3:
                this.life = "♥♥♥";
                break;
            case 2:
                this.life = "♥♥";
                break;
            case 1:
                this.life = "♥";
                break;

        }
        
        return this.life;  
    }

    public Integer getEnergia() {
        return energia;
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

    // Setters
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setVida(Integer vida) {
        
        if(vida < 0 || vida > 5)
            System.out.println("Parametro Invalido");
        else
        this.vida = vida;
    }

    public void setEnergia(Integer energia) {
        if(energia < 0 || energia > 100)
            System.out.println("Parametro Invalido");
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


    // Metodos propios    
    @Override
    public String toString() {
        return "\n\n[NOMBRE:" + this.getNombre() + "\033[031m VIDA:" + this.getVida() + " \033[34mENERGIA:" + this.getEnergia() + "\033[30m]";//To change body of generated methods, choose Tools | Templates.
    }

}
