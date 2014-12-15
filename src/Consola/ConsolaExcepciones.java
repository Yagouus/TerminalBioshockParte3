
package Consola;

import javax.swing.JOptionPane;


public class ConsolaExcepciones implements Consola{
    
     @Override
     public void imprimir(String mensaje){
         
         JOptionPane.showMessageDialog(null, mensaje , "NO!", JOptionPane.ERROR_MESSAGE);
         
     }
     

    @Override
    public String leer(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
