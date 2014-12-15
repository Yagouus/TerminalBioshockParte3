package Comandos;

import Personajes.Jugador;
import javax.swing.ImageIcon;

public class ComandoCoger implements Comando {

    private Jugador jugador;
    private String objeto;

    public ComandoCoger(Jugador jugador, String objeto) {

        this.jugador = jugador;
        this.objeto = objeto;

    }

    @Override
    public void ejecutar() {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        jugador.Coger(objeto);

    }
}
