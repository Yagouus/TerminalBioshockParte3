
package CargarPartida;

import terminalbioshock.Juego;


public class CargadorJuegoPorDefecto implements CargadorJuego{
    
     @Override
     public Juego cargarJuego(){
         
         Juego partida = new Juego();
         
         partida.Partidanueva();
         
         return partida;
         
         
         
     }
    
}
