package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Point2D;

public class Mur {
    public Mur(int id, Coin c1, Coin c2, PourMur... revetements)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.revetements = new ArrayList(Arrays.asList(revetements));
        if(this.revetements.isEmpty())
        {
            addRevetement("Defaut");
        }
        this.horizontal = c1.getY() == c2.getY();
    }
    
    public Mur(Coin c1, Coin c2)
    {
        this.id = MainProg.GenererId();
        this.c1 = c1;
        this.c2 = c2;
        this.revetements = new ArrayList();
        addRevetement("Defaut");
        this.horizontal = c1.getY() == c2.getY();
    }
    
    private int id;
    private Coin c1;
    private Coin c2;
    private ArrayList<PourMur> revetements;
    private boolean horizontal;
    
    
    public double cout()
    {
        double cout = 0;
        for(PourMur pm : revetements)
        {
            cout += pm.cout(Coin.DistanceEntre(c1, c2) * 3);
        }
        return cout;
    }
    public double longueur()
    {
        return Coin.DistanceEntre(c1, c2);
    }
    
    public Point2D milieu()
    {
        return new Point2D((c1.getX() + c2.getX())/2, (c1.getY() + c2.getY())/2);
    }
    
    
    public void addRevetement(String nom)
    {
        this.revetements.add(MagasinDeRevetements.getPourMur(nom));
    }

    public void setRevetement(int id, PourMur pm) {
        this.revetements.add(id, pm);
    }
    
    public PourMur getRevetement(int id)
    {
        return revetements.get(id);
    }
    
    public PourMur[] getRevetements()
    {
        PourMur[] ms = new PourMur[revetements.size()];
        for(int i =0; i<revetements.size(); i++)
        {
            ms[i] = revetements.get(i);
        }
        return ms;
    }

    public Coin getC1() {
        return c1;
    }
    
    //éviter d'appeler directement, changer depuis la piece si possible
    public void setC1(double x, double y) {
        c1.setX(x);
        c1.setY(y);
        if(horizontal)
        {
            c2.setY(y);
        }else{
            c2.setX(x);
        }
    }

    public Coin getC2() {
        return c2;
    }
    
    //éviter d'appeler directement, changer depuis la piece si possible
    public void setC2(double x, double y) {
        c2.setX(x);
        c2.setY(y);
        if(horizontal)
        {
            c1.setY(y);
        }else{
            c1.setX(x);
        }
    }

    public int getId() {
        return id;
    }
    
    public boolean estHorizontal()
    {
        return horizontal;
    }
    
    
    public String getTypeEtId()
    {
        return "M" + id;
    }

    @Override 
    public String toString() {
        String s = "M" + id + ">>C" + c1.getId() + ";C" + c2.getId() + ";";
        for(PourMur pm : revetements)
        {
            s += pm.getNom() + "&";
        }
        return s;
    }
}
