package thegroup.devisbat;
package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public class Plafond{
    
    private int id;
    private Piece piece;
    private Revetement revetement;

    public Plafond(int id, Piece piece, Revetement revetement) {
        this.piece = piece;
        this.revetement = revetement;
        this.id = id;
        this.piece.setPlafond(this);
    }
    public Plafond(int id, Piece piece, Revetement revetement, boolean save) {
        this.piece = piece;
        this.revetement = revetement;
        this.id = id;
        this.piece.setPlafond(this);
        if(save)
        {
            Sauveteur.add(this);
        }
    }
    
    
    public void setPiece(Piece p1)
    {
        this.piece = p1;
    }
    
    public double cout()
    {
        return revetement.cout(surface());
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
        return "P" + id +">>Piece" + piece.getId() + ";" + revetement.getNom();
    }
}
