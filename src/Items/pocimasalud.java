package Items;

import Personajes.Personaje;
import java.awt.Point;

public class pocimasalud extends Objeto {
    
    public pocimasalud(Point punto, String propietario, String nombre, String descripcion, Integer efecto, Float peso) {
        super(punto, propietario, nombre, descripcion, efecto, peso);
    }

    @Override
    public void Usar(Personaje personaje) {

        personaje.setVida(personaje.getVida() + this.efecto);
                //personaje.getMochila().getContenido().remove(personaje.getMochila().getContenido().get(i));

    }

}
