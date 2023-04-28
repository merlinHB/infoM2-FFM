package thegroup.devisbat;

/**
 *
 * @author fscheer01
 */
public class Piece {
    public Piece(int id, Mur[] murs)
    {
        this.id = id;
        this.murs = murs;
        this.coins = new Coin[4];
        for(int i = 0; i<4; i++)
        {
            this.coins[i] = this.murs[i].getC1();
        }
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
    
    public void setCoin(int numero, Coin c)
    {
        int coin = numero%4;
        int coinSuivant = (numero + 1)%4;
        int coinPrecedent = (numero + 3)%4;
        Sauveteur.set(coins[coin].getTypeEtId(), c);
        coins[coin] = c;
        murs[coin].setC1(c);
        murs[coinPrecedent].setC2(c);
        plafond.setSurface();
        sol.setSurface();
    }
    
    public Coin getCoin(int numero)
    {
        return coins[numero%4];
    }
    
    public Mur getMur(int numero)
    {
        return murs[numero%4];
    }
    
    public int getId() {
        return id;
    }
    public String getTypeEtId()
    {
        return "Piece" + id;
    }

    @Override
    public String toString() {
        String s = "Piece" + id + ">>";
        for(int i = 0; i<4; i++)
        {
            s += "M" + murs[i].getId() + ";";
        }
        s += "S" + sol.getId() + ";P" + plafond.getId();
        return s;
    }
}
