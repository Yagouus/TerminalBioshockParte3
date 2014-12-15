package Comandos;

import Excepciones.ExcepcionUsar;
import Personajes.Jugador;

public class ComandoUsar implements Comando {

    private Jugador jugador;
    private String objeto;

    public ComandoUsar(Jugador jugador, String objeto) {

        this.jugador = jugador;
        this.objeto = objeto;

    }

    @Override
    public void ejecutar() throws ExcepcionUsar {

        if (jugador.getMochila().getContenido().isEmpty()) {
            throw new ExcepcionUsar();
        }

        for (int i = 0; i < jugador.getMochila().getContenido().size(); i++) {

            if (jugador.getMochila().getContenido().get(i).getNombre().equals(objeto)) {
                try {
                    jugador.getMochila().getContenido().get(i).Usar(jugador);
                } catch (ExcepcionUsar m) {
                    throw new ExcepcionUsar();

                }
            }

        }

    }
}
