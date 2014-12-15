package Personajes;

import Excepciones.ExcepcionHablar;
import Excepciones.ExcepcionMovimiento;
import Excepciones.ExcepcionTirar;
import terminalbioshock.Juego;
import Items.Objeto;
import Items.objetoarma;
import Items.objetodefensivo;
import Mapa.Mapa;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Personaje {

    protected String Nombre;
    protected Integer vida;
    protected Integer energia;
    protected Integer fuerza;
    protected Integer defensa;
    protected Integer pasos;
    protected Mochila mochila;
    protected String frase;
    protected Point posicion;
    protected ArrayList<String> recorrido;
    protected ArrayList<Point> movimientos;
    protected Mapa mapa;
    protected Juego accionesPersonaje;

    public Personaje(Mapa mapa) {

        this.Nombre = "Unknown";
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
        this.accionesPersonaje = new Juego();

    }

    public Personaje(Point punto, String nombre, Integer vida, Integer energia, Integer fuerza, Integer defensa, String frase) {
        this.posicion = punto;
        this.Nombre = nombre;
        this.vida = vida;
        this.energia = energia;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.frase = frase;
        this.mochila = new Mochila();
        this.accionesPersonaje = new Juego();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();

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
        this.accionesPersonaje = new Juego();

    }

    public Personaje() {

        this.Nombre = "Unknown";
        this.vida = 5;
        this.energia = 100;
        this.fuerza = 10;
        this.defensa = 7;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.accionesPersonaje = new Juego();
    }

    public Personaje(String nombre) {

        this.Nombre = nombre;
        this.vida = 5;
        this.energia = 100;
        this.fuerza = 10;
        this.defensa = 7;
        this.pasos = 0;
        this.mochila = new Mochila();
        this.recorrido = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.accionesPersonaje = new Juego();
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

    public Juego getAccionesPersonaje() {
        return accionesPersonaje;
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

    //ACCIONES
    public void Mover(String aux) throws ExcepcionMovimiento {

        String Mensaje = "";
        int resta = 3;

        Point posicionPersonaje = new Point();
        int x, y;

        x = getPosicion().x;
        y = getPosicion().y;

        switch (aux) {

            case "n":
            case "norte":
            case "Norte":

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
                        throw new ExcepcionMovimiento();
                    }
                } else {
                    throw new ExcepcionMovimiento();
                }
                break;

            case "s":
            case "sur":
            case "Sur":

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
                        throw new ExcepcionMovimiento();
                    }
                } else {
                    throw new ExcepcionMovimiento();
                }
                break;

            case "e":
            case "este":
            case "Este":

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
                        throw new ExcepcionMovimiento();
                    }
                } else {
                    throw new ExcepcionMovimiento();
                }
                break;

            case "o":
            case "oeste":
            case "Oeste":

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
                        throw new ExcepcionMovimiento();
                    }
                } else {
                    throw new ExcepcionMovimiento();
                }
                break;

        }

    }

    public void Coger(String objeto) {

        for (int i = 0; i < getMapa().getMapa().get(getPosicion()).getItems().size(); i++) {

            if (getMapa().getMapa().get(getPosicion()).getItems().get(i).getNombre().equals(objeto)) {
                if (getFuerza() > 10 && getMapa().getMapa().get(getPosicion()).getItems().get(i) instanceof objetoarma) {
                    JOptionPane.showMessageDialog(null, "No puedes llevar mas de un arma", "NO!", JOptionPane.ERROR_MESSAGE);
                } else if (getDefensa() > 0 && getMapa().getMapa().get(getPosicion()).getItems().get(i) instanceof objetodefensivo) {
                    JOptionPane.showMessageDialog(null, "No puedes llevar mas de un objeto de defensa", "NO!", JOptionPane.ERROR_MESSAGE);

                } else {

                    anadirMochila(getMapa().getMapa().get(getPosicion()).getItems().get(i));

                    if (getMapa().getMapa().get(getPosicion()).getItems().get(i) instanceof objetoarma) {
                        setFuerza(getFuerza() + getMapa().getMapa().get(getPosicion()).getItems().get(i).getEfecto());
                    } else if (getMapa().getMapa().get(getPosicion()).getItems().get(i) instanceof objetodefensivo) {
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

    public void Tirar(Objeto objeto) throws ExcepcionTirar {

        int j = 0;

        if (objeto instanceof objetoarma) {
            setFuerza(getFuerza() - objeto.getEfecto());
        } else if (objeto instanceof objetodefensivo) {
            setDefensa(getDefensa() - objeto.getEfecto());
        }

        for (int i = 0; i < getMochila().getContenido().size(); i++) {

            if (getMochila().getContenido().get(i).equals(objeto)) {

                getMapa().getMapa().get(getPosicion()).getItems().add(getMochila().getContenido().get(i));
                getMochila().getContenido().remove(getMochila().getContenido().get(i));

                j++;
            }

        }

        if (j == 0) {

            throw new ExcepcionTirar();

        }
    }

    public void Mirar() {

        if (this.getMapa().getMapa().get(this.getPosicion()).getDescripcion() != null) {
            JOptionPane.showMessageDialog(null, "\n" + this.getMapa().getMapa().get(this.getPosicion()).getDescripcion());
        }

        if (this.getMapa().getMapa().get(this.getPosicion()).getItems().size() != 0) {
            JOptionPane.showMessageDialog(null, "Encuentras:\n" + this.getMapa().getMapa().get(this.getPosicion()).getItems());
        } else {
            JOptionPane.showMessageDialog(null, "No has encontrado nada...");

        }

        if (this.getMapa().getMapa().get(this.getPosicion()).getNPCS().size() != 0) {
            JOptionPane.showMessageDialog(null, "Te encuentras:\n" + this.getMapa().getMapa().get(this.getPosicion()).getNPCS().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No te has encontrado con nadie...");
        }
    }

    public void ojearInventario() {

        JOptionPane.showMessageDialog(null, this.getMochila().getContenido().toString() + "\nPeso: " + this.getMochila().getPeso(), "Mochila", JOptionPane.INFORMATION_MESSAGE);

    }

    public void hablar(String nombre) throws ExcepcionHablar {

        if (this.getMapa().getMapa().get(this.getPosicion()).getNPCS().isEmpty()) {

            throw new ExcepcionHablar();

        }

        int w = 0;

        for (int i = 0; i < this.getMapa().getMapa().get(this.getPosicion()).getNPCS().size(); i++) {

            if (this.getMapa().getMapa().get(this.getPosicion()).getNPCS().get(i).getNombre().equals(nombre)) {
                w++;
                JOptionPane.showMessageDialog(null, this.getMapa().getMapa().get(this.getPosicion()).getNPCS().get(i).getNombre() + " dice: \n" + this.getMapa().getMapa().get(this.getPosicion()).getNPCS().get(i).getFrase());
            }

        }

        if (w == 0) {

            throw new ExcepcionHablar();

        }
    }

    @Override
    public String toString() {
        return "NOMBRE:" + this.getNombre() + " VIDA:" + this.getVida() + " ENERGIA:" + this.getEnergia() + " FUERZA: " + this.getFuerza() + " DEFENSA: " + this.getDefensa();
    }

}
