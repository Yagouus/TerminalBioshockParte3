package Comandos;

import Personajes.Jugador;

public class ComandoInventario implements Comando{
 
    private Jugador jugador;
    private String objeto;

    public ComandoInventario(Jugador jugador) {

        this.jugador = jugador;


    }

    @Override
    public void ejecutar() {

        jugador.ojearInventario();
    }
    }

   
