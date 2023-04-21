package thegroup.devisbat;

/**
 *
 * @author fscheer01
 */
public class Piece {
    public Piece(int id, Mur[] murs, Coin[] coins)
    {
        this.id = id;
        this.murs = murs;
        this.coins = coins;
    }
    private int id;
    private Mur[] murs;
    private Coin[] coins;
    
    private Sol sol;
    private Plafond plafond;
    
    public void setSol(Sol sol)
    {
        this.sol = sol;
    }
    
    public void setPlafond(Plafond plafond)
    {
        this.plafond = plafond;
    }
    
    public double devisPiece()
    {
        double cout = sol.cout() + plafond.cout();
        for(Mur m : murs)
        {
            cout += m.cout();
        }
        return cout;
    }
    
    public double surfacePiece() {
        double surfacepiece = murs[0].longueur() * murs[1].longueur();
        return surfacepiece;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String s = "Piece" + id + "(";
        for(int i = 0; i<4; i++)
        {
            s += "M" + murs[i].getId() + ";";
        }
        s += "S" + sol.getId() + ";P" + plafond.getId() + ")";
        return s;
    }
}
