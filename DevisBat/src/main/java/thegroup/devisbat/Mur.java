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
    public void setC1(Coin c1) {
        this.c1 = c1;
        if(horizontal)
        {
            c2.setY(c1.getY());
        }else{
            c2.setX(c1.getX());
        }
    }

    public Coin getC2() {
        return c2;
    }
    
    //éviter d'appeler directement, changer depuis la piece si possible
    public void setC2(Coin c2) {
        this.c2 = c2;
        if(horizontal)
        {
            c1.setY(c2.getY());
        }else{
            c1.setX(c2.getX());
        }
    }

    public int getId() {
        return id;
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
