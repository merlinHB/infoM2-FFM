/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 *
 * @author fplumet01
 */
public class PieceGraphique extends Polygon{
    public PieceGraphique(double... coos)
    {
        super(coos);
        this.coos = coos;
    }
    
    public Piece piece;
    private double[] coos;
    
    public void CreerPiece()
    {
        Coin[] coins = new Coin[coos.length/2];
        for(int i = 0; i<coins.length; i++)
        {
            Point2D pt = DessinCanvas.screenToRealPos(coos[i], coos[i+1]);
            coins[i] = new Coin(pt.getX(), pt.getY());
        }
        this.piece = new Piece(coins);
    }
}
