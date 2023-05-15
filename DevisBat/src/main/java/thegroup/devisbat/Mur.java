package thegroup.devisbat;

public class Mur {
    public Mur(int id, Coin c1, Coin c2, Revetement revetement)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.revetement = revetement;
        this.horizontal = c1.getY() == c2.getY();
    }
    
    public Mur(int id, Coin c1, Coin c2, Revetement revetement, boolean save)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.revetement = revetement;
        this.horizontal = c1.getY() == c2.getY();
        if(save){
            Sauveteur.add(this);
        }
    }
    
    private int id;
    private Coin c1;
    private Coin c2;
    private Revetement revetement;
    private boolean horizontal;
    
    
    public double cout()
    {
        return revetement.cout(Coin.DistanceEntre(c1, c2) * 3);
    }
    public double longueur()
    {
        return Coin.DistanceEntre(c1, c2);
    }

    public Revetement getRevetement() {
        return revetement;
    }

    public void setRevetement(Revetement revetement) {
        this.revetement = revetement;
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
        return "M" + id + ">>C" + c1.getId() + ";C" + c2.getId() + ";" + revetement.getNom();
    }
}
