package thegroup.devisbat;

import java.io.*;
import java.util.HashMap;

public class Sauveteur
{
    private static HashMap<String, Object> objets = new HashMap<>();
    
    public static void add(Object obj)
    {
        String index = obj.toString().split(">>")[0];
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
    
    public static void clear()
    {
        objets.clear();
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
                bw.write(obj.toString() + "/ ");
                System.out.println(obj.toString() +" Enregistré !");
            }
            bw.close();
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
    
    public static void Ouvrir(String nomDuFichier)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(nomDuFichier));
            String txtFichier = br.readLine();
            String[] strObjets = txtFichier.split("/ ");
            br.close();
            Sauveteur.objets.clear();
            
            /*int a = txtFichier.indexOf(strObjets[0].split(">>")[0]);
            int b = txtFichier.indexOf(strObjets[0].split(">>")[0], a);
            String coin = txtFichier.substring(a, b);*/
            
            
            //coins
            for(String s : strObjets)
            {
                if(s.startsWith("C"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("C", ""));
                    double x = Double.parseDouble((s.split(">>")[1].split(";")[0]));
                    double y = Double.parseDouble((s.split(">>")[1].split(";")[1]));
                    Sauveteur.add(new Coin(id,x,y));
                }
            }
            //murs
            for(String s : strObjets)
            {
                if(s.startsWith("M"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("M", ""));
                    Coin c1 = (Coin)Sauveteur.get(s.split(">>")[1].split(";")[0]);
                    Coin c2 = (Coin)Sauveteur.get(s.split(">>")[1].split(";")[1]);
                    Revetement r = MagasinDeRevetements.getRevetement(s.split(">>")[1].split(";")[2]);
                    PourMur[] lpm = new PourMur[s.split(">>")[1].split(";")[1].split("&").length];
                    for(int i = 0; i<lpm.length; i++)
                    {
                        lpm[i] = MagasinDeRevetements.getPourMur(s.split(">>")[1].split(";")[1].split("&")[i]);
                    }
                    Sauveteur.add(new Mur(id, c1, c2, lpm));
                }
            }
            //piece
            for(String s : strObjets)
            {
                if(s.startsWith("Piece"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("Piece", ""));
                    Mur m0 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[0]);
                    Mur m1 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[1]);
                    Mur m2 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[2]);
                    Mur m3 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[3]);
                    Piece p = new Piece(id, new Mur[]{m0, m1, m2, m3});
                    
                    int a = txtFichier.indexOf(s.split(">>")[1].split(";")[4] + ">>");
                    int b = txtFichier.indexOf("/ ", a);
                    String strSol = txtFichier.substring(a, b);
                    int idSol = Integer.parseInt(strSol.split(">>")[0].replace("S", ""));
                    PourSol[] lps = new PourSol[strSol.split(">>")[1].split(";")[1].split("&").length];
                    for(int i = 0; i<lps.length; i++)
                    {
                        lps[i] = MagasinDeRevetements.getPourSol(strSol.split(">>")[1].split(";")[1].split("&")[i]);
                    }
                    Sol sol = new Sol(idSol, p, lps);
                    
                    a = txtFichier.indexOf(s.split(">>")[1].split(";")[5] + ">>");
                    b = txtFichier.indexOf("/ ", a);
                    String strPlaf = txtFichier.substring(a, b);
                    int idPlaf = Integer.parseInt(strPlaf.split(">>")[0].replace("P", ""));
                    PourPlafond[] lpp = new PourPlafond[strPlaf.split(">>")[1].split(";")[1].split("&").length];
                    for(int i = 0; i<lpp.length; i++)
                    {
                        lpp[i] = MagasinDeRevetements.getPourPlafond(strSol.split(">>")[1].split(";")[1].split("&")[i]);
                    }
                    Plafond plaf = new Plafond(idPlaf, p, lpp);
                    
                    Sauveteur.add(p);
                }
            }
            //appartements
            for(String s : strObjets)
            {
                if(s.startsWith("A"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("A", ""));
                    Piece[] pieces = new Piece[s.split(">>")[1].split(";").length - 1];
                    for(int i = 0; i<pieces.length; i++)
                    {
                        pieces[i] = (Piece)Sauveteur.get(s.split(">>")[1].split(";")[i]);
                    }
                    String proprio = s.split(">>")[1].split(":")[1];
                    Sauveteur.add(new Appartement(id, pieces, proprio));
                }
            }
            //niveaux
            for(String s : strObjets)
            {
                if(s.startsWith("N"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("N", ""));
                    Appartement[] apparts = new Appartement[s.split(">>")[1].split(";").length];
                    for(int i = 0; i<apparts.length; i++)
                    {
                        apparts[i] = (Appartement)Sauveteur.get(s.split(">>")[1].split(";")[i]);
                    }
                    Sauveteur.add(new Niveau(id, apparts));
                }
            }
            //batiment
            for(String s : strObjets)
            {
                if(s.startsWith("B"))
                {
                    int id = Integer.parseInt(s.split(">>")[0].replace("B", ""));
                    Niveau[] nvx = new Niveau[s.split(">>")[1].split(";").length];
                    for(int i = 0; i<nvx.length; i++)
                    {
                        nvx[i] = (Niveau)Sauveteur.get(s.split(">>")[1].split(";")[i]);
                    }
                    Sauveteur.add(new Batiment(id, nvx));
                }
            }
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
