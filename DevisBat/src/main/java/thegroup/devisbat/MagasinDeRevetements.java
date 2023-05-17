package thegroup.devisbat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author FeliPlum
 */
public class MagasinDeRevetements {
    private static HashMap<Integer, String> ids = new HashMap<>();
    private static HashMap<String, PourPlafond> pourPlafonds = new HashMap<>();
    private static HashMap<String, PourMur> pourMurs = new HashMap<>();
    private static HashMap<String, PourSol> pourSols = new HashMap<>();
    
    public static void LireRevetements()
    {
        //les éléments sont lus dans un fichier qui s'appelle "Revetements.revetus" dans le dossier DevisBat du projet
        //les infos sont séparées par ": " dans le fichier
        //l'id du revtmnt est le numéro de sa ligne (éviter que plusieurs aient le mm id)
        //les rvtmnts sont triés grâce au prmeier mot de chaque ligne
        //éviter les accents
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Revetements.revetus"));
            br.readLine();
            String temp = br.readLine();
            int i = 0;
            while(temp != null)
            {
                String[] elementsDuRev = temp.split(";");
                int id = Integer.parseInt(elementsDuRev[0]);
                String nom = elementsDuRev[1];
                boolean pourMur = (elementsDuRev[2].contains("1"));
                boolean pourSol = (elementsDuRev[3].contains("1"));
                boolean pourPlafond = (elementsDuRev[4].contains("1"));
                double prix = Double.parseDouble(elementsDuRev[5]);
                if(pourMur)
                {
                    pourMurs.put(nom, new PourMur(id, nom, prix));
                }
                if(pourSol)
                {
                    pourSols.put(nom, new PourSol(id, nom, prix));
                }
                if(pourPlafond)
                {
                    pourPlafonds.put(nom, new PourPlafond(id, nom, prix));
                }
                ids.put(id, nom);
                
                temp = br.readLine();
                i++;
            }
            br.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
    
    public static Revetement getRevetement(int id)
    {
        String nom = ids.get(id);
        if(pourMurs.containsKey(nom))
        {
            return pourMurs.get(nom);
        }else if(pourSols.containsKey(nom))
        {
            return pourSols.get(nom);
        }else if(pourPlafonds.containsKey(nom))
        {
            return pourPlafonds.get(nom);
        }else{
            return null;
        }
    }
    
    public static Revetement getRevetement(String nom)
    {
        if(pourPlafonds.containsKey(nom))
        {
            return pourPlafonds.get(nom);
        }else if(pourMurs.containsKey(nom))
        {
            return pourMurs.get(nom);
        }else if(pourSols.containsKey(nom))
        {
            return pourSols.get(nom);
        }else 
        {
            return null;
        }
    }
    
    public static Revetement[] getListeDeRevetement()
    {
        Revetement[] liste = new Revetement[ids.size()];
        ArrayList<Revetement> revs = new ArrayList();
        revs.addAll(pourMurs.values());
        revs.addAll(pourSols.values());
        revs.addAll(pourPlafonds.values());
        return (Revetement[])revs.toArray();
    }
    
    public static PourMur getPourMur(String nom)
    {
        return pourMurs.getOrDefault(nom, pourMurs.get("Defaut"));
    }
    
    public static PourPlafond getPourPlafond(String nom)
    {
        return pourPlafonds.getOrDefault(nom, pourPlafonds.get("Defaut"));
    }
    
    public static PourSol getPourSol(String nom)
    {
        return pourSols.getOrDefault(nom, pourSols.get("Defaut"));
    }
}
