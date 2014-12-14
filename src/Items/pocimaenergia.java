package Items;

import Personajes.Personaje;
import java.awt.Point;

public class pocimaenergia extends Objeto{
    
    public pocimaenergia(Point punto, String propietario, String nombre, String descripcion, Integer efecto, Float peso) {
        super(punto, propietario, nombre, descripcion, efecto, peso);
    }


    @Override
    public void Usar(Personaje personaje) {

        personaje.setEnergia(personaje.getEnergia() + this.efecto);
        

    }
}
