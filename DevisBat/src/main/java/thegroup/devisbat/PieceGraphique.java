/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import javafx.scene.shape.Polygon;

/**
 *
 * @author fplumet01
 */
public class PieceGraphique extends Polygon{
    public PieceGraphique(double... coos)
    {
        super(coos);
        Coin[] coins = new Coin[coos.length/2];
        for(int i = 0; i<coos.length; i += 2)
        {
            coins[i] = new Coin(coos[i], coos[i+1]);
        }
        piece = new Piece(coins);
    }
    
    private Piece piece;
}
