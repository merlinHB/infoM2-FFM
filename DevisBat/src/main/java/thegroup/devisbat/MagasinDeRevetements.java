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
    private static HashMap<Integer, Revetement> revetements = new HashMap<>();
    private static HashMap<String, Isolant> isolants = new HashMap<>();
    private static HashMap<String, Carrelage> carrelages = new HashMap<>();
    private static HashMap<String, Peinture> peintures = new HashMap<>();
    
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
            ArrayList<String> listeDeStringLues = new ArrayList<String>();
            String temp = br.readLine();
            int i = 0;
            while(temp != null)
            {
                System.out.println(temp + " ajouté, id : " + i);
                listeDeStringLues.add(temp);
                temp = br.readLine();
                i++;
            }
            
            i = 0;
            for(String s : listeDeStringLues)
            {
                String[] elementsDuRev = s.split(": ");
                String type = elementsDuRev[0];
                String nom = elementsDuRev[1];
                double prix = Double.parseDouble(elementsDuRev[2]);
                
                if(type.contains("Isolant"))
                {
                    isolants.put(nom, new Isolant(i, nom, prix));
                    revetements.put(i, new Isolant(i, nom, prix));
                }else if(type.contains("Carrelage"))
                {
                    carrelages.put(nom, new Carrelage(i, nom, prix));
                    revetements.put(i, new Carrelage(i, nom, prix));
                }else if(type.contains("Peinture"))
                {
                    peintures.put(nom, new Peinture(i, nom, prix));
                    revetements.put(i, new Peinture(i, nom, prix));
                }else
                {
                    System.out.println("Element non reconnu : " + type);
                }
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
        return MagasinDeRevetements.revetements.get(id);
    }
    
    public static Revetement getRevetement(String nom)
    {
        Revetement rev = isolants.get(nom);
        if(isolants.containsKey(nom))
        {
            return isolants.get(nom);
        }else if(carrelages.containsKey(nom))
        {
            return carrelages.get(nom);
        }else if(peintures.containsKey(nom))
        {
            return peintures.get(nom);
        }else 
        {
            System.out.println("Revetement '"+nom+"' non trouvé");
        }
        return rev;
    }
    
    public static Revetement[] getListeDeRevetement()
    {
        Revetement[] liste = new Revetement[MagasinDeRevetements.revetements.size()];
        for(int i = 0; i<liste.length; i++)
        {
            liste[i] = MagasinDeRevetements.revetements.get(i);
        }
        return liste;
    }
    
    public static Carrelage getCarrelage(String nom)
    {
        return MagasinDeRevetements.carrelages.getOrDefault(nom, MagasinDeRevetements.carrelages.get("Defaut"));
    }
    
    public static Isolant getIsolant(String nom)
    {
        return MagasinDeRevetements.isolants.get(nom);
    }
    
    public static Peinture getPeinture(String nom)
    {
        return MagasinDeRevetements.peintures.get(nom);
    }
}
