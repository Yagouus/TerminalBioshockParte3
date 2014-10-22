/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Items.Objeto;
import java.awt.Point;
import java.util.ArrayList;

public class Celda {
    private Point coordenadas;
    private String descripcion;
    private ArrayList<Objeto> items;
    private boolean transitable;
    private boolean esInicio;
    private boolean esFin;
    
}
