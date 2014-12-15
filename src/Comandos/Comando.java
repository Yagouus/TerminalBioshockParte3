
package Comandos;

import Excepciones.ExcepcionJuego;

public interface Comando {
    
    public void ejecutar() throws ExcepcionJuego;
    
}
