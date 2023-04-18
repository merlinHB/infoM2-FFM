/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public class Sol extends Solouplafond{
    
    
  

    public Sol(int id, Piece p1) {
        super(id, p1);
       
    }
    @Override
    
     public void setP1(Piece p1){
        this.p1 = p1;
        this.surfacesol = p1.surfacepiece();
    }
    
    @Override
        public Piece getP1(){
        return p1;
    }

    @Override
    public String toString() {
        return "Sol{" + "id=" + id + ", surfacesol=" + surfacesol + ", p1=" + p1 + '}';
    }

    
    
}
