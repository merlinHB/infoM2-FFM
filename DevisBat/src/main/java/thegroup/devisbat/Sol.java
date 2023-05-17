package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mhibou01
 */
public class Sol{
    
    private int id;
    private Piece piece;
    private ArrayList<PourSol> revetements;

    public Sol(int id, Piece piece, PourSol... revetements) {
        this.piece = piece;
        this.revetements = new ArrayList(Arrays.asList(revetements));
        if(this.revetements.isEmpty())
        {
            addRevetement("Defaut");
        }
        this.id = id;
        this.piece.setSol(this);
    }
    
    public Sol(Piece piece, PourSol... revetements) {
        this.piece = piece;
        this.revetements = new ArrayList(Arrays.asList(revetements));
        if(this.revetements.isEmpty())
        {
            addRevetement("Defaut");
        }
        this.id = MainProg.GenererId();
        this.piece.setSol(this);
    }
    
    public void addRevetement(String nom)
    {
        this.revetements.add(MagasinDeRevetements.getPourSol(nom));
    }
    
    
    public void setPiece(Piece p1)
    {
        this.piece = p1;
    }
    
    public double cout()
    {
        double cout = 0;
        for(PourSol ps : revetements)
        {
            cout += ps.cout(surface());
        }
        return cout;
    }

    public double surface() {
        return piece.surfacePiece();
    }
    

    @Override
    public String toString() {
        String s = "S" + id +">>Piece" + piece.getId() + ";";
        for(PourSol ps : revetements)
        {
            s += ps.getNom() + "&";
        }
        return s;
    }

    public int getId() {
        return id;
    }

    public String getTypeEtId()
    {
        return "S" + id;
    }
    
}
