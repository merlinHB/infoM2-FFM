package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public class Sol{
    
    private int id;
    private Piece piece;
    private double surface;
    private Revetement revetement;

    public Sol(int id, Piece piece, Revetement revetement) {
        this.piece = piece;
        this.revetement = revetement;
        this.surface = piece.surfacePiece();
        this.id = id;
        this.piece.setSol(this);
    }
    
    public Sol(int id, Piece piece, Revetement revetement, boolean save) {
        this.piece = piece;
        this.revetement = revetement;
        this.surface = piece.surfacePiece();
        this.id = id;
        this.piece.setSol(this);
        if(save)
        {
            Sauveteur.add(this);
        }
    }
    
    
    public void setPiece(Piece p1)
    {
        this.piece = p1;
        this.surface = p1.surfacePiece();
    }
    
    public double cout()
    {
        return revetement.cout(surface);
    }

    public void setSurface() {
        this.surface = piece.surfacePiece();
    }
    

    @Override
    public String toString() {
        return "S" + id +">>Piece" + piece.getId() + ";" + revetement.getNom();
    }

    public int getId() {
        return id;
    }

    public String getTypeEtId()
    {
        return "S" + id;
    }
    
}
