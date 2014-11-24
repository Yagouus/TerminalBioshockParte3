package Mapa;

import Items.Objeto;
import MainCharacter.Personaje;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class Mapa {

    private String Nombre;
    private String Descripcion;
    private HashMap<Point, Celda> mapa;
    private ArrayList<Personaje> NPCS;
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

    public Mapa() {
        tamaño = new Point();
        mapa = new HashMap<>();
    }

    // Getters
    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }

    // Setters
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setMapa(HashMap<Point, Celda> mapa) {
        this.mapa = mapa;
    }

    public void setTamaño(int x, int y) {

        this.tamaño.x = x;
        this.tamaño.y = y;

    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.NPCS = personajes;
    }

    // Metodos propios
    public void insertaCelda(int x, int y, Celda celda) {

        Point punto = new Point(x, y);
        mapa.put(punto, celda);

    }

    public void descubrirCelda(Personaje personaje) {

        personaje.getPosicion();

    }

    public void imprimeMapa(Personaje personaje) {

        personaje.getMapa().visibilidad(personaje);

        for (int i = 0; i < tamaño.x; i++) {
            System.out.print("\n");
            for (int j = 0; j < tamaño.y; j++) {
                if (this.getMapa().get(new Point(i, j)) != null) {
                    if (this.getMapa().get(new Point(i, j)).equals(personaje.getMapa().getMapa().get(personaje.getPosicion()))) {
                        System.out.print("@ ");
                    } else {
                        if (this.getMapa().get(new Point(i, j)).isTransitable()) {
                            if (this.getMapa().get(new Point(i, j)).isVisible()) {
                                if (this.getMapa().get(new Point(i, j)).getTipo().equals("camino")) {
                                    System.out.print(". ");
                                } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("edificacion")) {
                                    System.out.print("# ");
                                } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("bosque")) {
                                    System.out.print("^ ");
                                } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("prado")) {
                                    System.out.print("_ ");
                                }
                            } else {
                                System.out.print("? ");
                            }
                        } else {
                            if (this.getMapa().get(new Point(i, j)).isVisible()) {
                                System.out.print("X ");
                            } else {
                                System.out.print("? ");
                            }
                        }
                    }
                }
            }
        }

    }

    public void imprimeMapa() {

        for (int i = 0; i < tamaño.x; i++) {
            System.out.print("\n");
            for (int j = 0; j < tamaño.y; j++) {
                if (this.getMapa().get(new Point(i, j)) != null) {
                    if (this.getMapa().get(new Point(i, j)).getTipo().equals("camino")) {
                        System.out.print(". ");
                    } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("edificacion")) {
                        System.out.print("# ");
                    } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("bosque")) {
                        System.out.print("^ ");
                    } else if (this.getMapa().get(new Point(i, j)).getTipo().equals("prado")) {
                        System.out.print("_ ");
                    }
                }
            }
        }

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

    public void visibilidad(Personaje personaje) {

        Point posicionPersonaje = new Point();
        int x, y;

        x = personaje.getPosicion().x;
        y = personaje.getPosicion().y;

        String aux = null;

        //Propia
        posicionPersonaje.x = x;
        posicionPersonaje.y = y;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        // Norte
        posicionPersonaje.x = x - 1;
        posicionPersonaje.y = y;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //Sur
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //Este
        posicionPersonaje.x = x;
        posicionPersonaje.y = y + 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //Oeste
        posicionPersonaje.x = x;
        posicionPersonaje.y = y - 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //NorOeste
        posicionPersonaje.x = x;
        posicionPersonaje.y = y - 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //NorEste
        posicionPersonaje.x = x - 1;
        posicionPersonaje.y = y - 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //SurEste
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y + 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

        //SurOeste
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y - 1;

        if (personaje.getMapa().getMapa().get(posicionPersonaje) != null) {
            personaje.getMapa().getMapa().get(posicionPersonaje).setVisible();
        }

    }

    public void crearMuros() {
        for (int i = 0; i < tamaño.x; i++) {
            for (int j = 0; j < tamaño.y; j++) {
                if (this.getMapa().get(new Point(i, j)) == null) {

                    this.insertaCelda(i, j, new Celda());

                }

            }

        }
    }

    public void colocaObjetos(ArrayList<Objeto> objetos) {

        for (int i = 0; i < objetos.size(); i++) {

            this.getMapa().get(objetos.get(i).getPosicion()).getItems().add(objetos.get(i));
            
        }

    }
    
}
