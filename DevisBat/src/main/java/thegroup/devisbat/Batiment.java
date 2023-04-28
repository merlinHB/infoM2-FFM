package thegroup.devisbat;


public class Batiment {

    public Batiment(int id, Niveau[] niveaux) {
        this.id = id;
        this.niveaux = niveaux;
    }
    
    public Batiment(int id, Niveau[] niveaux, boolean save) {
        this.id = id;
        this.niveaux = niveaux;
        if(save){
            Sauveteur.add(this);
        }
    }
    
    private int id;
    private Niveau[] niveaux;
    
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
        return niveaux;
    }

    public void setNiveaux(Niveau[] niveaux) {
        this.niveaux = niveaux;
    }
    
    public Niveau getNiveau(int numero) {
        return niveaux[numero%niveaux.length];
    }

    public void setNiveaux(int numero, Niveau niveau) {
        niveaux[numero%niveaux.length] = niveau;
    }
    
    public int getNbrNiveaux()
    {
        return niveaux.length;
    }

    @Override
    public String toString() {
        String s = "B" + id + ">>";
        for(int i = 0; i<niveaux.length; i++)
        {
            s += niveaux[i].getTypeEtId() + ";";
        }
        return s;
    }
    
    
}
