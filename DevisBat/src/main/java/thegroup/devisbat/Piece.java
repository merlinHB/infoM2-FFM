package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author fscheer01
 */
public class Piece {
    public Piece(int id, Mur[] murs)
    {
        this.id = id;
        this.murs = new ArrayList<Mur>(Arrays.asList(murs));
    }
    public Piece(int id, Coin[] coins)
    {
        this.id = id;
        this.murs = new ArrayList<Mur>();
        for(int i =0; i<coins.length; i++)
        {
            this.murs.add(new Mur(coins[i].getId(), coins[i], coins[(i+1)%coins.length]));
        }
    }
    public Piece(Coin[] coins)
    {
        this.id = MainProg.GenererId();
        this.murs = new ArrayList<Mur>();
        for(int i =0; i<coins.length; i++)
        {
            Mur m = new Mur(MainProg.GenererId(), coins[i], coins[(i+1)%coins.length]);
            this.murs.add(m);
        }
    }
    
    private int id;
    private ArrayList<Mur> murs;
    
    private Sol sol;
    private Plafond plafond;
    
    public int nbrMurs()
    {
        return murs.size();
    }
    
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
    
    public double surfacePiece(){
        double l1 = murs.get(0).longueur();
        int i = 0;
        while(murs.get(i).estHorizontal() == murs.get((i + 1)%murs.size()).estHorizontal())
        {
            l1 += murs.get((i + 1)%murs.size()).longueur();
            i++;
        }
        i++;
        double l2 = murs.get(i%murs.size()).longueur();
        while(murs.get(i).estHorizontal() == murs.get((i + 1)%murs.size()).estHorizontal())
        {
            l2 += murs.get((i + 1)%murs.size()).longueur();
            i++;
        }
        return l1 * l2;
    }
    
    public void setCoin(int numero, double x, double y)
    {
//        ArrayList<Coin> coinsH;//coins reliés horizontalement au coin qu'on replace
//        ArrayList<Coin> coinsV;//idem mais verticalement
//        int i = 0;
//        while(murs.get(i).estHorizontal() == murs.get((i + 1)%murs.size()).estHorizontal())
//        {
//            if(murs.get(i).estHorizontal())
//            {
//                murs.get(i).setC1(murs.get(i).getId(), );
//            }
//            l2 += murs.get((i + 1)%murs.size()).longueur();
//            i++;
//        }
        int coin = numero%murs.size();
        int coinPrecedent = (numero + murs.size() - 1)%murs.size();
        murs.get(coin).setC1(x, y);
        murs.get(coinPrecedent).setC2(x, y);
    }
    
    public Coin getCoin(int numero)
    {
        return murs.get(numero%murs.size()).getC1();
    }
    
    public Coin[] getCoins()
    {
        Coin[] coins = new Coin[murs.size()];
        for(int i =0; i<murs.size(); i++)
        {
            coins[i] = murs.get(i).getC1();
        }
        return coins;
    }
    
    public Mur getMur(int numero)
    {
        return murs.get(numero%murs.size());
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
        for(Mur m : murs)
        {
            s += "M" + m.getId() + ";";
        }
        s += "S" + sol.getId() + ";P" + plafond.getId();
        return s;
    }
}
