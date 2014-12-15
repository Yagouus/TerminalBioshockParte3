package Excepciones;

import javax.swing.JOptionPane;


public class ExcepcionMovimiento extends ExcepcionJuego {
    
    @Override
public void ExcepcionJuego(){
    
    JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
    
}
    
}
