package thegroup.devisbat;

/**
 *
 * @author fplumet01
 */
public class Appartement {

    public Appartement(int id, Niveau niveau, Piece[] pieces, String proprio) {
        this.id = id;
        this.niveau = niveau;
        this.pieces = pieces;
        this.proprio = proprio;
    }
    
    private int id;
    private Niveau niveau;
    private Piece[] pieces;
    private String proprio;
    
    public double surface()
    {
        double s = 0;
        for(Piece p : pieces)
        {
            s += p.surfacePiece();
        }
        return s;
    }
    
    public void dessiner()
    {
        //
    }
    
    public double devisAppartement()
    {
        double cout = 0;
        for(Piece p : pieces){
            cout += p.devisPiece();
        }
        return cout;
    }
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String proprio) {
        this.proprio = proprio;
    }
}
