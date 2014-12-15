package Consola;

public class ConsolaCutre implements Consola {

    @Override
    public void imprimir(String mensaje) {

        System.out.println(mensaje);

    }

    @Override
    public String leer(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
