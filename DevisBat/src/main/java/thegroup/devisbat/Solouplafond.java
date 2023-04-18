/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public abstract class Solouplafond {
    
    protected int id;
    protected double surfacesol;
    protected Piece p1;
    
    
    public Solouplafond(int id, Piece p1) {
        this.id = id;
        this.p1 = p1;
    }
    
    public void setP1(Piece p1){
        this.p1 = p1;
        this.surfacesol = p1.surfacepiece();
        
    }
   
       public Piece getP1(){
        return p1;
    }
    
}
