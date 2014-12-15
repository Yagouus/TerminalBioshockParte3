package Comandos;

import Excepciones.ExcepcionTirar;
import Excepciones.ExcepcionUsar;
import Personajes.Jugador;
import javax.swing.ImageIcon;

public class ComandoTirar implements Comando {

    private Jugador jugador;
    private String objeto;

    public ComandoTirar(Jugador jugador, String objeto) {

        this.jugador = jugador;
        this.objeto = objeto;

    }


    @Override
    public void ejecutar()throws ExcepcionTirar{

        ImageIcon icon = new ImageIcon("Images/finn.gif");
        int w = 0;
        
        if (jugador.getMochila().getContenido().isEmpty()) {
                    throw new ExcepcionTirar();
                }

                for (int i = 0; i < jugador.getMochila().getContenido().size(); i++) {
                    if (jugador.getMochila().getContenido().get(i).getNombre().equals(objeto)) {
                        try {
                            jugador.Tirar(jugador.getMochila().getContenido().get(i));
                            w++;
                        } catch (ExcepcionTirar n) {
                            throw new ExcepcionTirar();
                        }
                        if (w == 0) {
                            throw new ExcepcionTirar();
                        }
                    }
                }

   

    }

}
