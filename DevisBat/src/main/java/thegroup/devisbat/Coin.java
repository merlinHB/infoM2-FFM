package thegroup.devisbat;

import static java.lang.Math.sqrt;

/*@author fplumet01*/
public class Coin {

    public Coin(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public Coin(int id, double x, double y, boolean save) {
        this.id = id;
        this.x = x;
        this.y = y;
        if(save)
        {
            Sauveteur.add(this);
        }
    }
    
    private int id;
    
    private double x;
    private double y;

    public static double DistanceEntre(Coin c1, Coin c2)
    {
        return sqrt((c1.x - c2.x)*(c1.x - c2.x) + (c1.y - c2.y)*(c1.y - c2.y));
    }

    @Override
    public String toString() {
        return "C" + id + "(" + x + ";" + y + ")";
    }
    
    public int getId() {
        return id;
    }
    
    public String getTypeEtId()
    {
        return "C" + id;
    }
    
    public double getX() {
        return x;
    }
    
    //éviter d'appeler directement, changer depuis la piece si possible
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    
    //éviter d'appeler directement, changer depuis la piece si possible
    public void setY(double y) {
        this.y = y;
    }
}
