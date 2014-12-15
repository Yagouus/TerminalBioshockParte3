package Consola;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConsolaOpciones implements Consola {
    
    ImageIcon icon = new ImageIcon("Images/finn.gif");

    @Override
    public void imprimir(String mensaje) {
        
        

    }

    @Override
    public String leer(String mensaje) {
        Object aux;

        aux = JOptionPane.showInputDialog(null, mensaje, "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
    
        return aux.toString();
    
    }

}
