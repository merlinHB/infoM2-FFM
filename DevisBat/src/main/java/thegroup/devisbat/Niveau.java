package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;

public class Niveau {
    
    public Niveau(int id, Appartement[] appartements) {
        this.id = id;
        this.appartements = new ArrayList<Appartement>(Arrays.asList(appartements));
    }
    
    public Niveau(boolean immeuble, Object... objs) {
        this.id = MainProg.GenererId();
        if(immeuble)
        {
            this.appartements = new ArrayList<Appartement>(Arrays.asList((Appartement[])objs));
        }else{
            this.appartements = new ArrayList<Appartement>(Arrays.asList(new Appartement("Propriétaire")));
            for(Object o : objs)
            {
                addPiece((Piece)o);
            }
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
    
    public void addAppartement(Appartement appart)
    {
        appartements.add(appart);
    }
    
    public void addPiece(Piece piece)
    {
        appartements.get(0).addPiece(piece);
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
