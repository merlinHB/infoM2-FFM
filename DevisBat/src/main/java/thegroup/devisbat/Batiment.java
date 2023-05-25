package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;


public class Batiment {

    public Batiment(int id, Niveau[] niveaux) {
        this.id = id;
        this.niveaux = new ArrayList<Niveau>(Arrays.asList(niveaux));
    }
    
    public Batiment(Niveau... niveaux) {
        this.id = MainProg.GenererId();
        this.niveaux = new ArrayList<Niveau>(Arrays.asList(niveaux));
    }
    
    private int id;
    private ArrayList<Niveau> niveaux;
    private boolean immeuble = false;
    
    public boolean isImmeuble()
    {
        return immeuble;
    }
    
    public double devisBatiment()
    {
        double cout = 0;
        for(Niveau n : niveaux){
            cout += n.devisNiveau();
        }
        return cout;
    }
    
    public double surface()
    {
        double surface = 0;
        for(Niveau n : niveaux){
            surface += n.surface();
        }
        return surface;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Niveau[] getNiveaux() {
        Niveau[] nvs = new Niveau[niveaux.size()];
        for(int i =0; i<niveaux.size(); i++)
        {
            nvs[i] = niveaux.get(i);
        }
        return nvs;
    }

    public void setNiveaux(Niveau[] niveaux) {
        this.niveaux = new ArrayList<Niveau>(Arrays.asList(niveaux));
    }
    
    public void addNiveau(Niveau niveau)
    {
        niveaux.add(niveau);
    }
    
    public Niveau getNiveau(int numero) {
        return niveaux.get(numero%niveaux.size());
    }

    public void setNiveaux(int numero, Niveau niveau) {
        niveaux.set(numero%niveaux.size(), niveau);
    }
    
    public int getNbrNiveaux()
    {
        return niveaux.size();
    }

    @Override
    public String toString() {
        String s = "B" + id + ">>";
        for(Niveau nv : niveaux)
        {
            s += nv.getTypeEtId() + ";";
        }
        return s;
    }
    
    
}
