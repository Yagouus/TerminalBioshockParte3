package Items;

import Excepciones.ExcepcionUsar;
import Personajes.Personaje;
import java.awt.Point;

public class objetodefensivo extends Objeto {

    public objetodefensivo(Point punto, String propietario, String nombre, String descripcion, Integer efecto, Float peso) {
        super(punto, propietario, nombre, descripcion, efecto, peso);
    }
    
     @Override
    public void Usar(Personaje personaje) throws ExcepcionUsar{       
        
        throw new ExcepcionUsar();
    }
    

}
