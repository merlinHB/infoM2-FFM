/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author fplumet01
 */
public class Appartement {

    public Appartement(int id, Piece[] pieces) {
        this.id = id;
        this.pieces = pieces;
    }
    
    int id;
    Piece[] pieces;
    String proprio;
    
    public double surface()
    {
        double s = 0;
        for(Piece p : pieces)
        {
            s += p.surfacePiece();
        }
        return s;
    }
    
    public void dessiner()
    {
        //
    }
    
    public double devisAppartement()
    {
        double cout = 0;
        for(Piece p : pieces){
            cout += p.;
        }
        return cout;
    }
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String proprio) {
        this.proprio = proprio;
    }
}
