package thegroup.devisbat;

import java.util.List;
import java.io.*;

public class SaveClass {
    public static List<Coin> coins;
    public static List<Mur> murs;
    public static List<Revetement> revetements;
    
    public static void Enregister()
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Enregistrement.tahLeDevis",true));
            for(int i =0; i<coins.size(); i++)
            {
                bw.write(coins[i]);
            }
            bw.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
