package thegroup.devisbat;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class SaveClass {
    public static List<Coin> coins = new ArrayList<>();
    public static List<Mur> murs = new ArrayList<>();;
    public static List<Revetement> revetements = new ArrayList<>();;
    
    public static void Enregister()
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Enregistrement.tahLeDevis", false));         
            bw.write("");
            bw.flush();
            for(int i =0; i<coins.size(); i++)
            {
                bw.write(coins.get(i) + "/");
            }
            bw.newLine();
            for(int i =0; i<murs.size(); i++)
            {
                bw.write(murs.get(i) + "/");
            }
            bw.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
