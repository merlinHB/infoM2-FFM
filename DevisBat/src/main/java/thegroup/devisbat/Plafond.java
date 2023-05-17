package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mhibou01
 */
public class Plafond{
    
    private int id;
    private Piece piece;
    private ArrayList<PourPlafond> revetements;

    public Plafond(int id, Piece piece, PourPlafond... revetements) {
        this.piece = piece;
        this.revetements = new ArrayList(Arrays.asList(revetements));
        if(this.revetements.isEmpty())
        {
            addRevetement("Defaut");
        }
        this.id = id;
        this.piece.setPlafond(this);
    }
    public Plafond(Piece piece, PourPlafond... revetements) {
        this.piece = piece;
        this.revetements = new ArrayList(Arrays.asList(revetements));
        if(this.revetements.isEmpty())
        {
            addRevetement("Defaut");
        }
        this.id = MainProg.GenererId();
        this.piece.setPlafond(this);
    }
    
    public void addRevetement(String nom)
    {
        this.revetements.add(MagasinDeRevetements.getPourPlafond(nom));
    }
    
    public void setPiece(Piece p1)
    {
        this.piece = p1;
    }
    
    public double cout()
    {
        double cout = 0;
        for(PourPlafond ps : revetements)
        {
            cout += ps.cout(surface());
        }
        return cout;
    }
    
    public double surface() {
        return piece.surfacePiece();
    }
    
    public int getId() {
        return id;
    }
    
    public String getTypeEtId()
    {
        return "P" + id;
    }
    
    @Override
    public String toString() {
        String s = "P" + id +">>Piece" + piece.getId() + ";";
        for(PourPlafond ps : revetements)
        {
            s += ps.getNom() + "&";
        }
        return s;
    }
}
