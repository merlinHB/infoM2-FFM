package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public abstract class Revetement {
    private int id;
    private String nom;
    private double prix;

    public Revetement(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    
    public double cout(double surface)
    {
        return surface * prix;
    }

    @Override
    public String toString() {
        return id + ": " + nom + ": " + prix;
    }

    public int getId() {
        return id;
    }
    
    public String getNom()
    {
        return nom;
    }
}
