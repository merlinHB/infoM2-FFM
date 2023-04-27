package thegroup.devisbat;

import java.io.*;
import java.util.HashMap;

public class Sauveteur
{
    private static HashMap<String, Object> objets = new HashMap<>();
    
    public static void add(Object obj)
    {
        //String index = obj.toString().replace("(","ù").split("ù")[0];
        String index = obj.toString().split("\\(")[0];
        Sauveteur.objets.put(index, obj);
    }
    
    public static Object get(String s)
    {
        return Sauveteur.objets.get(s);
    }
    
    public static void set(String s, Object obj)
    {
        if(Sauveteur.objets.containsKey(s))
        {
            Sauveteur.objets.replace(s, obj);
        }else{
            Sauveteur.objets.put(s, obj);
        }
        
    }
    
    public static void Enregister(String nomDuFichier)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomDuFichier, false));         
            bw.write("");
            bw.flush();
            for(Object obj : objets.values())
            {
                bw.write(obj.toString() + "/");
                System.out.println(obj.toString() + "/" + "Enregistré !");
            }
            bw.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
