package thegroup.devisbat;


public class Appartement {

    public Appartement(int id, Piece[] pieces, String proprio) {
        this.id = id;
        this.pieces = pieces;
        this.proprio = proprio;
    }
    public Appartement(int id, Piece[] pieces, String proprio, boolean save) {
        this.id = id;
        this.pieces = pieces;
        this.proprio = proprio;
        if(save){
            Sauveteur.add(this);
        }
    }
    
    private int id;
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
    
    public String getTypeEtId()
    {
        return "A" + id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piece[] getPieces() {
        return pieces;
    }
    
    public Piece getPiece(int numero)
    {
        return pieces[numero%pieces.length];
    }
    
    public void setPiece(int numero, Piece piece)
    {
        pieces[numero%pieces.length] = piece;
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
    
    

    @Override
    public String toString() {
        String s = "A" + id + ">>";
        for(int i = 0; i<pieces.length; i++)
        {
            s += pieces[i].getTypeEtId() + ";";
        }
        s += "Proprio:" + proprio;
        return s;
    }
    
    
}
