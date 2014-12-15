/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Excepciones.ExcepcionHablar;
import Personajes.Jugador;
import javax.swing.ImageIcon;

/**
 *
 * @author yagouus
 */
public class ComandoHablar implements Comando{


    private Jugador jugador;
    private String personaje;

    public ComandoHablar(Jugador jugador, String personaje) {

        this.jugador = jugador;
        this.personaje = personaje;

    }

    @Override
    public void ejecutar() throws ExcepcionHablar {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        jugador.hablar(personaje);

    }
    
}
