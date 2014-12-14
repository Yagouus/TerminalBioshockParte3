package Items;

import Personajes.Personaje;
import java.awt.Point;

public class objetomapa extends Objeto{
    
    public objetomapa(Point punto, String propietario, String nombre, String descripcion, Integer efecto, Float peso) {
        super(punto, propietario, nombre, descripcion, efecto, peso);
    }


    @Override
    public void Usar(Personaje personaje) {

        personaje.getMapa().tienesMapa(personaje);

    }

}
