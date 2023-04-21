package thegroup.devisbat;

public class Mur {
    public Mur(int id, Coin c1, Coin c2, Revetement revetement)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.revetement = revetement;
        Sauveteur.add(this);
    }
    private int id;
    private Coin c1;
    private Coin c2;
    private Revetement revetement;
    
    
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

    @Override 
    public String toString() {
        return "M" + id + "(C" + c1.getId() + ";C" + c2.getId() + ";R" + revetement.getId() +")";
    }
}
