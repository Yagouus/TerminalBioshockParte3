
package Comandos;

import Excepciones.ExcepcionMirar;
import Excepciones.ExcepcionUsar;
import Personajes.Jugador;

public class ComandoMirarObjeto implements Comando{

    private Jugador jugador;
    private String objeto;

    public ComandoMirarObjeto(Jugador jugador, String objeto) {

        this.jugador = jugador;
        this.objeto = objeto;

    }

    @Override
    public void ejecutar() throws ExcepcionMirar {

        if (jugador.getMochila().getContenido().isEmpty()) {
            throw new ExcepcionMirar();
        }
        
        int w = 0;

        for (int i = 0; i < jugador.getMochila().getContenido().size(); i++) {
            
            if (jugador.getMochila().getContenido().get(i).getNombre().equals(objeto)) {
                w++;                
                jugador.getMochila().getContenido().get(i).mirarObjeto(jugador);
            }

        }
        
        if(w == 0){
            
            throw new ExcepcionMirar();
            
        }

    }
    }

    

