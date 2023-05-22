package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;


public class Appartement {

    public Appartement(int id, Piece[] pieces, String proprio) {
        this.id = id;
        this.pieces = new ArrayList<Piece>(Arrays.asList(pieces));
        this.proprio = proprio;
    }
    public Appartement(String proprio, Piece... pieces) {
        this.id = MainProg.GenererId();
        this.pieces = new ArrayList<Piece>(Arrays.asList(pieces));
        this.proprio = proprio;
    }
    
    private int id;
    private ArrayList<Piece> pieces;
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
        return (Piece[])pieces.toArray();
    }
    
    public void addPiece(Piece piece)
    {
        pieces.add(piece);
    }
    
    public Piece getPiece(int numero)
    {
        return pieces.get(numero%pieces.size());
    }
    
    public void setPiece(int numero, Piece piece)
    {
        pieces.set(numero%pieces.size(),piece);
    }

    public void setPieces(ArrayList<Piece> pieces) {
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
        for(Piece p : pieces)
        {
            s += p.getTypeEtId() + ";";
        }
        s += "Proprio:" + proprio;
        return s;
    }
    
    
}
