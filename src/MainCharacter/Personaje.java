package MainCharacter;

import Items.Objeto;
import Mapa.Mapa;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

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
        this.mochila = new Mochila();
        this.accionesPersonaje = new Acciones();

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

    public String getTipo() {
        return this.tipo;
    }

    // Setters
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setVida(Integer vida) {

        this.vida = vida;

        if (this.vida < 0) {
            this.vida = 0;
        }

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

    public void setTipo(String tipo) {

        this.tipo = tipo;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    // Metodos propios    
    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public void anadirMochila(Objeto objeto) {

        if ((this.mochila.getPeso() + objeto.getPeso()) > this.mochila.getPesoMax()) {
            JOptionPane.showMessageDialog(null, "No puedes coger eso", "NO!", JOptionPane.ERROR_MESSAGE);
        } else {
            this.mochila.setContenido(objeto);
            this.mochila.actualizarPeso();
        }
    }

    //AHORA LAS ACCIONES VAN EN LOS PERSONAJES
    public void Mover(String aux) {

        String Mensaje = "";
        int resta = 3;

        Point posicionPersonaje = new Point();
        int x, y;

        x = getPosicion().x;
        y = getPosicion().y;

        switch (aux) {

            case "n":
            case "N":

                posicionPersonaje.x = x - 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        setMovimientos(getPosicion());
                        setPosicion(posicionPersonaje);
                        setRecorrido("Norte");

                        int a = (int) (getMochila().getPeso() % 5);
                        setEnergia(getEnergia() - (resta + a));

                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "s":
            case "S":

                posicionPersonaje.x = x + 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        setMovimientos(getPosicion());
                        setPosicion(posicionPersonaje);
                        setRecorrido("Sur");
                        int a = (int) (getMochila().getPeso() % 5);
                        setEnergia(getEnergia() - (resta + a));

                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "e":
            case "E":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y + 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        setMovimientos(getPosicion());
                        setPosicion(posicionPersonaje);
                        setRecorrido("Este");
                        int a = (int) (getMochila().getPeso() % 5);
                        setEnergia(getEnergia() - (resta + a));

                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "o":
            case "O":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y - 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        setMovimientos(getPosicion());
                        setPosicion(posicionPersonaje);
                        setRecorrido("Oeste");
                        int a = (int) (getMochila().getPeso() % 5);
                        setEnergia(getEnergia() - (resta + a));

                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

        }

    }

    public void Coger(String objeto) {

        for (int i = 0; i < getMapa().getMapa().get(getPosicion()).getItems().size(); i++) {

            if (getMapa().getMapa().get(getPosicion()).getItems().get(i).getNombre().equals(objeto)) {
                if (getFuerza() > 10 && getMapa().getMapa().get(getPosicion()).getItems().get(i).getTipo().equals("arma")) {
                    JOptionPane.showMessageDialog(null, "No puedes llevar mas de un arma", "NO!", JOptionPane.ERROR_MESSAGE);
                } else if (getDefensa() > 0 && getMapa().getMapa().get(getPosicion()).getItems().get(i).getTipo().equals("defensa")) {
                    JOptionPane.showMessageDialog(null, "No puedes llevar mas de un objeto de defensa", "NO!", JOptionPane.ERROR_MESSAGE);

                } else {

                    anadirMochila(getMapa().getMapa().get(getPosicion()).getItems().get(i));

                    if (getMapa().getMapa().get(getPosicion()).getItems().get(i).getModificador().equals("fuerza")) {
                        setFuerza(getFuerza() + getMapa().getMapa().get(getPosicion()).getItems().get(i).getEfecto());
                    } else if (getMapa().getMapa().get(getPosicion()).getItems().get(i).getModificador().equals("defensa")) {
                        setDefensa(getDefensa() + getMapa().getMapa().get(getPosicion()).getItems().get(i).getEfecto());
                    }

                    getMapa().getMapa().get(getPosicion()).getItems().remove(getMapa().getMapa().get(getPosicion()).getItems().get(i));
                }
            }

        }

    }

    public void atacar(Personaje Enemigo) {

        /*getMapa().getMapa().get(getPosicion()).getNPCS().get(i).setVida(getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getVida() - (20 + (getFuerza() / 10) - (getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getDefensa() / 10)));
        JOptionPane.showMessageDialog(null, "Has atacado a tu enemigo!\n Le has quitado: " + ((20 + (getFuerza() / 10) - (getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getDefensa() / 10))) + " puntos de vida", "NO!", JOptionPane.ERROR_MESSAGE);

        if (getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getTipo().equals("enemigopasivo") && getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getNombre().equals(nombre) && getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getVida() > 0) {

            setVida(getVida() - (2 + (getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getFuerza() / 10) - getDefensa() / 10));
            JOptionPane.showMessageDialog(null, "Te han atacado!\n Te han quitado: " + (10 + (getMapa().getMapa().get(getPosicion()).getNPCS().get(i).getFuerza() / 10) - getDefensa() / 10) + " puntos de vida", "NO!", JOptionPane.ERROR_MESSAGE);

        }*/
    }

        
    @Override
    public String toString() {
        return "NOMBRE:" + this.getNombre() + " VIDA:" + this.getVida() + " ENERGIA:" + this.getEnergia() + " FUERZA: " + this.getFuerza() + " DEFENSA: " + this.getDefensa();
    }

}
