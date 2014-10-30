package Items;

public class Objeto {
    
    String nombre;
    String tipo;
    Integer peso;
    Integer efecto;
    
    public Objeto(){
        
       nombre = "Unknown";
       tipo = "Unknown";
       peso = 0;
       efecto = 0;
        
    }
    
    public Objeto(String nombre, String tipo, Integer peso, Integer efecto){
        
       this.nombre = nombre;
       this.tipo = tipo;
       this.peso = peso;
       this.efecto = efecto;
        
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
