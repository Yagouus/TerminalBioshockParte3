package CargarPartida;

import terminalbioshock.Juego;

public class CargadorJuegoDeFicheros implements CargadorJuego {
    
    private String directorio;
    
    public CargadorJuegoDeFicheros(String directorio){
        
        this.directorio = directorio;
        
    }
    
    @Override
     public Juego cargarJuego(){
         
         Juego partida = new Juego();
         
         partida.cargar(directorio);
         
         return partida;
         
         
         
     }
    
}
