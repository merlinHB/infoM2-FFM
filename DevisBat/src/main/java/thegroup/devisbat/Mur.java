package thegroup.devisbat;

public class Mur {
    public Mur(int id, Coin c1, Coin c2)
    {
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
    }
    private int id;
    private Coin c1;
    private Coin c2;
    private Revetement revetement;

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
        return "M" + id + "(" + c1 + ";" + c2 + ")";
    }
}
