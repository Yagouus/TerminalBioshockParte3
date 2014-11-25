
package MainCharacter;


import Items.Objeto;
import java.util.ArrayList;

public class Mochila {
   
    private final Integer capacidad;
    private final Integer pesoMax;
    private Float peso;   
    private Integer nObjetos;
    ArrayList<Objeto> contenido;
    
    // Constructores
    public Mochila(){
        
    this.capacidad = 10;
    this.pesoMax = 10;
    this.peso = 0f;   
    this.nObjetos = 0;
    this.contenido = new ArrayList<>();
        
    }
    
    public Mochila(Integer capacidad, Integer pesoMax, ArrayList<Objeto> contenido){
        
    this.capacidad = capacidad;
    this.pesoMax = pesoMax;
    this.peso = this.getPeso();   
    this.nObjetos = contenido.size();
    this.contenido = contenido;
        
    }

    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getPesoMax() {
        return pesoMax;
    }

    public Float getPeso() {
        
        this.actualizarPeso();
        
        return this.peso;
    }

    public Integer getnObjetos() {
        return nObjetos;
    }

    public ArrayList<Objeto> getContenido() {
        return contenido;
    }
    
    public ArrayList<Objeto> getConenidoUsable(){
        
        ArrayList<Objeto> usables = new ArrayList<>();
        
        for(int i = 0; i < this.contenido.size(); i++){
            
            usables.add(this.contenido.get(i));
            
        }
        
        return usables;
        
    }
    
    // Setters
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setnObjetos(Integer nObjetos) {
        this.nObjetos = nObjetos;
    }

    public void setContenido(ArrayList<Objeto> contenido) {
        this.contenido = contenido;
    }
  
    public void setContenido(Objeto contenido) {
        this.contenido.add(contenido);
    }      
    
    // Metodos Propios   
    public void actualizarPeso(){
        
        Float pesamen = 0f;
        
        for(int i = 0; i < this.contenido.size(); i++){
            pesamen += this.getContenido().get(i).getPeso();
        }
        
        this.peso = pesamen;
    }
    
}
