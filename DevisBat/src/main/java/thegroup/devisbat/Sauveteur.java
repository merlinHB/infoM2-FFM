package thegroup.devisbat;

import java.io.*;
import java.util.HashMap;

public class Sauveteur
{
    private HashMap<String, Object> objets = new HashMap<>();
    
    public void add(Object obj)
    {
        String index = obj.toString().replace("(","ù").split("ù")[0];
        this.objets.put(index, obj);
    }
    
    public Object get(String s)
    {
        return this.objets.get(s);
    }
    
    public void Enregister(String nomDuFichier)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomDuFichier, false));         
            bw.write("");
            bw.flush();
            for(Object obj : objets.values())
            {
                bw.write(obj.toString() + "/");
            }
            bw.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
