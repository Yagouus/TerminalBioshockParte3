package Comandos;

import Excepciones.ExcepcionAtacar;
import Personajes.Enemigo;
import Personajes.Jugador;
import Personajes.Personaje;

public class ComandoAtacar implements Comando {

    private final Jugador jugador;
    private final String objeto;

    public ComandoAtacar(Jugador jugador, String enemigo) {

        this.jugador = jugador;
        this.objeto = enemigo;

    }

    @Override
    public void ejecutar() throws ExcepcionAtacar {

        int index = 0;
        Personaje enemigo = new Personaje();
             

        for (int i = 0; i < jugador.getMapa().getMapa().get(jugador.getPosicion()).getNPCS().size(); i++) {

            if (jugador.getMapa().getMapa().get(jugador.getPosicion()).getNPCS().get(index).getNombre().equals(objeto)) {
                index++;
                enemigo = jugador.getMapa().getMapa().get(jugador.getPosicion()).getNPCS().get(i);
            }

        }
        
        if(index == 0){
            
            throw new ExcepcionAtacar();
            
        }

        jugador.atacar(enemigo);
    }

}
