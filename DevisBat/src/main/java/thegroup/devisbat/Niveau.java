package thegroup.devisbat;

public class Niveau {
    
    public Niveau(int id, Appartement[] appartements) {
        this.id = id;
        this.appartements = appartements;
    }
    
    public Niveau(int id, Appartement[] appartements, boolean save) {
        this.id = id;
        this.appartements = appartements;
        if(save){
            Sauveteur.add(this);
        }
    }
    
    private int id;
    private Appartement[] appartements;

    public double devisNiveau()
    {
        double cout = 0;
        for(Appartement a : appartements){
            cout += a.devisAppartement();
        }
        return cout;
    }
    
    public double surface()
    {
        double surface = 0;
        for(Appartement a : appartements){
            surface += a.surface();
        }
        return surface;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getTypeEtId()
    {
        return "N"+id;
    }
    
    @Override
    public String toString() {
        String s = "N" + id + ">>";
        for(int i = 0; i<appartements.length; i++)
        {
            s += appartements[i].getTypeEtId() + ";";
        }
        return s;
    }
}
