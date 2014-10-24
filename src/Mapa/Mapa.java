/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import java.awt.Point;
import java.util.HashMap;


public final class Mapa {
    private String Descripcion;
    private HashMap<Point,Celda> mapa;
    private final Point tamaño;
    
    public Mapa(int x, int y){
        
        this.tamaño = new Point(x,y);
        this.mapa = new HashMap<>();
        for(int i = 0; i < tamaño.x ; i++){
            for(int j = 0; j < tamaño.y; j++){
                Celda celda = new Celda();
                this.insertaCelda(i, j, celda);
            }
        }
        
                
    }   
  
    public void insertaCelda(int x, int y, Celda celda){
       
        Point punto = new Point(x,y);
        mapa.put(punto,celda);
        
    }
    
    public void imprimeMapa(){
      
        for(int i = 0; i < tamaño.x ; i++){
            System.out.print("\n");
            for(int j = 0; j < tamaño.y; j++){               
                System.out.print(this.getMapa().get(new Point(i,j)) + "\t");
            }
        }
        
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<Point, Celda> mapa) {
        this.mapa = mapa;
    }
    
}
