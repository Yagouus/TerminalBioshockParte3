package Comandos;

import Personajes.Jugador;
import javax.swing.ImageIcon;

public class ComandoMover implements Comando {

    private Jugador jugador;
    private String direccion;

    public ComandoMover(Jugador jugador, String Direccion) {

        this.jugador = jugador;
        this.direccion = Direccion;

    }

    @Override
    public void ejecutar() {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        jugador.Mover(direccion);
    }

}
