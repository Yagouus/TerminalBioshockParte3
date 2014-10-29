package Mapa;

import MainCharacter.Personaje;
import java.awt.Point;
import java.util.HashMap;

public final class Mapa {

    private String Descripcion;
    private HashMap<Point, Celda> mapa;
    private final Point tamaño;

    // Constructor
    public Mapa(int x, int y) {

        this.tamaño = new Point(x, y);
        this.mapa = new HashMap<>();
        for (int i = 0; i < tamaño.x; i++) {
            for (int j = 0; j < tamaño.y; j++) {
                Celda celda = new Celda();
                this.insertaCelda(i, j, celda);
            }
        }

        //descripcion
        
    }

    // Getters
    public String getDescripcion() {
        return Descripcion;
    }

    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }

    // Setters
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setMapa(HashMap<Point, Celda> mapa) {
        this.mapa = mapa;
    }

    // Metodos propios
    public void insertaCelda(int x, int y, Celda celda) {

        Point punto = new Point(x, y);
        mapa.put(punto, celda);

    }

    public void imprimeMapa(Personaje personaje) {
        

        for (int i = 0; i < tamaño.x; i++) {
            System.out.print("\n");
            for (int j = 0; j < tamaño.y; j++) {
                if(personaje.getPosicion().equals(new Point(i,j))){
                    System.out.print("☻ ");
                }else{
                System.out.print(this.getMapa().get(new Point(i, j)) + " ");
                }
            }
        }

    }

    public void mapaTransitable(Mapa map) {

        map.getMapa().get(new Point(8, 0)).setTransitable(true);
        map.getMapa().get(new Point(8, 1)).setTransitable(true);
        map.getMapa().get(new Point(7, 1)).setTransitable(true);
        map.getMapa().get(new Point(6, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 2)).setTransitable(true);
        map.getMapa().get(new Point(5, 3)).setTransitable(true);
        map.getMapa().get(new Point(5, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 6)).setTransitable(true);
        map.getMapa().get(new Point(4, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 3)).setTransitable(true);
        map.getMapa().get(new Point(3, 3)).setTransitable(true);
        map.getMapa().get(new Point(2, 3)).setTransitable(true);
        map.getMapa().get(new Point(2, 4)).setTransitable(true);
        map.getMapa().get(new Point(2, 5)).setTransitable(true);
        map.getMapa().get(new Point(2, 6)).setTransitable(true);
        map.getMapa().get(new Point(2, 7)).setTransitable(true);
        map.getMapa().get(new Point(2, 8)).setTransitable(true);
        map.getMapa().get(new Point(3, 8)).setTransitable(true);
        map.getMapa().get(new Point(4, 8)).setTransitable(true);
        map.getMapa().get(new Point(5, 8)).setTransitable(true);
        map.getMapa().get(new Point(6, 8)).setTransitable(true);
        map.getMapa().get(new Point(7, 8)).setTransitable(true);
        map.getMapa().get(new Point(8, 8)).setTransitable(true);
        map.getMapa().get(new Point(8, 7)).setTransitable(true);
        map.getMapa().get(new Point(8, 6)).setTransitable(true);
        map.getMapa().get(new Point(7, 6)).setTransitable(true);
        map.getMapa().get(new Point(6, 6)).setTransitable(true);
        map.getMapa().get(new Point(6, 5)).setTransitable(true);
        map.getMapa().get(new Point(6, 4)).setTransitable(true);
        map.getMapa().get(new Point(6, 3)).setTransitable(true);
        map.getMapa().get(new Point(7, 3)).setTransitable(true);
        map.getMapa().get(new Point(8, 3)).setTransitable(true);
        map.getMapa().get(new Point(8, 2)).setTransitable(true);
        map.getMapa().get(new Point(1, 5)).setTransitable(true);
        map.getMapa().get(new Point(0, 5)).setTransitable(true);
        map.getMapa().get(new Point(1, 1)).setTransitable(true);
        map.getMapa().get(new Point(2, 1)).setTransitable(true);
        map.getMapa().get(new Point(2, 2)).setTransitable(true);
        map.getMapa().get(new Point(1, 8)).setTransitable(true);
        map.getMapa().get(new Point(1, 9)).setTransitable(true);
        map.getMapa().get(new Point(8, 9)).setTransitable(true);

        //Descripciones
        
        map.getMapa().get(new Point(8, 0)).setDescripcion("Entras en las catacumbas de Rapture a traves de una gran puerta, tras tu primer paso en ella estas se iluminan.\n"
                + "Al adentrarte en la cueva, en la pared derecha ves una estatua de un hombre en la que dice: \n\t\t'NO GODS OR KINGS.\n\t\t    ONLY MAN'\n"
                + "Al fondo del oscuro pasillo se ve una batisfera, entras en ella, y esta desciende numerosos metros bajo el mar.\nDurante el descenso escuchas a dos hombres "
                + "hablar a traves de la radio de la batisfera.\nMiras a traves de sus cristales observando una increible ciudad submarina.");
        map.getMapa().get(new Point(8, 1)).setDescripcion("");        
        map.getMapa().get(new Point(8, 2)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 3)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 7)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 8)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(7, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(7, 3)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(7, 1)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(6, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 5)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 4)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 3)).setDescripcion(Descripcion);        
        map.getMapa().get(new Point(6, 1)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(5, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(5, 3)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(5, 1)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(4, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(4, 3)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(3, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(3, 3)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(2, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 7)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 5)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 4)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 3)).setDescripcion(Descripcion);
    
        map.getMapa().get(new Point(1, 5)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(0, 5)).setDescripcion(Descripcion);
        
        
        

    }

    public Point getInicio() {
        for (int i = 0; i < this.tamaño.x; i++) {
            for (int j = 0; j < this.tamaño.y; j++) {
                if (this.mapa.get(new Point(i, j)).isEsInicio()) {
                    return new Point(i, j);
                } 
            }
        }
        return null;
    }
      
    
    
}
