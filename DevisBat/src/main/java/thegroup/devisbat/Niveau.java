package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;

public class Niveau {
    
    public Niveau(int id, Appartement[] appartements) {
        this.id = id;
        this.appartements = new ArrayList<Appartement>(Arrays.asList(appartements));
    }
    
    public Niveau(int id, Appartement[] appartements, boolean save) {
        this.id = id;
        this.appartements = new ArrayList<Appartement>(Arrays.asList(appartements));
        if(save){
            Sauveteur.add(this);
        }
    }
    
    private int id;
    private ArrayList<Appartement> appartements;

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
        for(Appartement a : appartements)
        {
            s += a.getTypeEtId() + ";";
        }
        return s;
    }
}
