/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author fscheer01
 */
public class Piece {
    public Piece(int id, Coin c1, Coin c2, Coin c3, Coin c4)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
    }
    private int id;
    private Coin c1;
    private Coin c2;
    private Coin c3;
    private Coin c4;

    public Coin getC1() {
        return c1;
    }

    public void setC1(Coin c1) {
        this.c1 = c1;
    }

    public Coin getC2() {
        return c2;
    }

    public void setC2(Coin c2) {
        this.c2 = c2;
    }

    public int getId() {
        return id;
    }
    
    public Coin getC3() {
        return c3;
    }

    public void setC3(Coin c3) {
        this.c3 = c3;
    }
    
    public Coin getC4() {
        return c4;
    }

    public void setC4(Coin c4) {
        this.c4 = c4;
    }
    
    public double surfacepiece() {
        double surfacepiece = Math.abs(c1.getX()-c2.getX())*Math.abs(c1.getY()-c4.getY());
        return surfacepiece;
    }
}
