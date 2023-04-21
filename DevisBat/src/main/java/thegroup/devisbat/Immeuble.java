package thegroup.devisbat;

/**
 *
 * @author FeliPlum
 */
public class Immeuble {
    
    private int id;
    private Niveau[] niveaux;

    public Immeuble(int id, Niveau[] niveaux) {
        this.id = id;
        this.niveaux = niveaux;
    }
}
