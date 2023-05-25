package thegroup.devisbat;

import java.io.*;
import java.util.HashMap;

public class Sauveteur
{
    private static HashMap<String, Object> objets = new HashMap<>();
    public static HashMap<Integer, Niveau> niveauxObjs = new HashMap<>();
    public static HashMap<Integer, Appartement> appartementsObjs = new HashMap<>();
    public static HashMap<Integer, Piece> piecesObjs = new HashMap<>();
    public static HashMap<Integer, Sol> solsObjs = new HashMap<>();
    public static HashMap<Integer, Plafond> plafondsObjs = new HashMap<>();
    public static HashMap<Integer, Mur> mursObjs = new HashMap<>();
    public static HashMap<Integer, Coin> coinsObjs = new HashMap<>();
    
    public static void add(Object obj)
    {
        switch (obj.getClass().getName()){
                case "thegroup.devisbat.Niveau":
                    Sauveteur.niveauxObjs.put(((Niveau)obj).getId(), (Niveau)obj);
                    break;
                case "thegroup.devisbat.Appartement":
                    Sauveteur.appartementsObjs.put(((Appartement)obj).getId(), (Appartement)obj);
                    break;
                case "thegroup.devisbat.Piece":
                    Sauveteur.piecesObjs.put(((Piece)obj).getId(), (Piece)obj);
                    break;
                case "thegroup.devisbat.Sol":
                    Sauveteur.solsObjs.put(((Sol)obj).getId(), (Sol)obj);
                    break;
                case "thegroup.devisbat.Plafond":
                    Sauveteur.plafondsObjs.put(((Plafond)obj).getId(), (Plafond)obj);
                    break;
                case "thegroup.devisbat.Mur":
                    Sauveteur.mursObjs.put(((Mur)obj).getId(), (Mur)obj);
                    break;
                case "thegroup.devisbat.Coin":
                    Sauveteur.coinsObjs.put(((Coin)obj).getId(), (Coin)obj);
                    break;
                default:
                    System.out.println(obj.getClass().getName() + " ne correspond à aucun type");
                    break;
        }
//        String index = obj.toString().split(">>")[0];
//        Sauveteur.objets.put(index, obj);
    }
//    
//    public static Object get(String s)
//    {
//        return Sauveteur.objets.get(s);
//    }
//    
//    public static void set(String s, Object obj)
//    {
//        if(Sauveteur.objets.containsKey(s))
//        {
//            Sauveteur.objets.replace(s, obj);
//        }else{
//            Sauveteur.objets.put(s, obj);
//        }
//        
//    }
    
    public static void clear()
    {
        niveauxObjs.clear();
        appartementsObjs.clear();
        piecesObjs.clear();
        solsObjs.clear();
        plafondsObjs.clear();
        mursObjs.clear();
        coinsObjs.clear();
    }
    
    public static void Enregister(String nomDuFichier)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomDuFichier, false));         
            bw.write("");
            bw.flush();
//            for(Object obj : objets.values())
//            {
//                bw.write(obj.toString() + "/ ");
//                System.out.println(obj.toString() +" Enregistré !");
//            }
            bw.write(MainProg.Batimentfinal.toString());
            for(Niveau n : niveauxObjs.values())
            {
                bw.write(n.toString() + "/ ");
            }
            bw.write("\n");
            for(Appartement a : appartementsObjs.values())
            {
                bw.write(a.toString() + "/ ");
            }
            bw.write("\n");
            for(Piece p : piecesObjs.values())
            {
                bw.write(p.toString() + "/ ");
            }
            bw.write("\n");
            for(Sol s : solsObjs.values())
            {
                bw.write(s.toString() + "/ ");
            }
            bw.write("\n");
            for(Plafond p : plafondsObjs.values())
            {
                bw.write(p.toString() + "/ ");
            }
            bw.write("\n");
            for(Mur m : mursObjs.values())
            {
                bw.write(m.toString() + "/ ");
            }
            bw.write("\n");
            for(Coin c: coinsObjs.values())
            {
                bw.write(c.toString() + "/ ");
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
            br.close();
            Sauveteur.objets.clear();
            
            String strBat = br.readLine();
            String[] strsNvs = br.readLine().split("/");
            String[] strsApparts = br.readLine().split("/");
            String[] strsPieces = br.readLine().split("/");
            String[] strsSols = br.readLine().split("/");
            String[] strsPlafs = br.readLine().split("/");
            String[] strsMurs = br.readLine().split("/");
            String[] strsCoins = br.readLine().split("/");
            
            for(String s : strsCoins)
            {
                int id = Integer.parseInt(s.split(">>")[0].replace("C", ""));
                double x = Double.parseDouble((s.split(">>")[1].split(";")[0]));
                double y = Double.parseDouble((s.split(">>")[1].split(";")[1]));
                Sauveteur.add(new Coin(id,x,y));
            }
            for(String s : strsMurs)
            {
                int id = Integer.parseInt(s.split(">>")[0].replace("M", ""));
                int idC1 = Integer.parseInt(s.split(">>")[1].split(";")[0].replace("C", ""));
                int idC2 = Integer.parseInt(s.split(">>")[1].split(";")[1].replace("C", ""));
                Coin c1 = coinsObjs.get(idC1);
                Coin c2 = coinsObjs.get(idC2);
                PourMur[] lpm = new PourMur[s.split(">>")[1].split(";")[1].split("&").length];
                for(int i = 0; i<lpm.length; i++)
                {
                    lpm[i] = MagasinDeRevetements.getPourMur(s.split(">>")[1].split(";")[1].split("&")[i]);
                }
                Sauveteur.add(new Mur(id, c1, c2, lpm));
            }
            for(String s : strsPieces)
            {
                int id = Integer.parseInt(s.split(">>")[0].replace("Piece", ""));
                Mur[] murs = new Mur[s.split(">>")[1].split(";").length-2];
                for(int i = 2; i<s.split(">>")[1].split(";").length; i++)
                {
                    int idM = Integer.parseInt(s.split(">>")[1].split(";")[i].replace("M", ""));
                    murs[i-2] = mursObjs.get(idM);
                }
                Piece p = new Piece(id, murs);
                   
                int k = 0;
                int idSol = Integer.parseInt(s.split(">>")[1].split(";")[0].replace("S", ""));
                while(strsSols[k].contains(String.valueOf(idSol)))
                {
                    k++;
                }
                PourSol[] lps = new PourSol[strsSols[k].split(">>")[1].split(";")[1].split("&").length];
                for(int i = 0; i<lps.length; i++)
                {
                    lps[i] = MagasinDeRevetements.getPourSol(strsSols[k].split(">>")[1].split(";")[1].split("&")[i]);
                }
                Sol sol = new Sol(idSol, p, lps);
                
                k = 0;
                int idPlaf = Integer.parseInt(s.split(">>")[1].split(";")[1].replace("P", ""));
                while(strsPlafs[k].contains(String.valueOf(idPlaf)))
                {
                    k++;
                }
                PourPlafond[] lpp = new PourPlafond[strsPlafs[k].split(">>")[1].split(";")[1].split("&").length];
                for(int i = 0; i<lpp.length; i++)
                {
                    lpp[i] = MagasinDeRevetements.getPourPlafond(strsSols[k].split(">>")[1].split(";")[1].split("&")[i]);
                }
                Plafond plaf = new Plafond(idPlaf, p, lpp);

                Sauveteur.add(plaf);
                Sauveteur.add(sol);
                Sauveteur.add(p);
            }
            for(String s : strsApparts)
            {
                int id = Integer.parseInt(s.split(">>")[0].replace("A", ""));
                Piece[] pieces = new Piece[s.split(">>")[1].split(";").length - 1];
                for(int i = 0; i<pieces.length; i++)
                {
                    pieces[i] = piecesObjs.get(Integer.parseInt(s.split(">>")[1].split(";")[i].replace("M", "")));
                }
                String proprio = s.split(">>")[1].split(":")[1];
                Sauveteur.add(new Appartement(id, pieces, proprio));
            }
            for(String s : strsNvs)
            {
                int id = Integer.parseInt(s.split(">>")[0].replace("N", ""));
                Appartement[] apparts = new Appartement[s.split(">>")[1].split(";").length];
                for(int i = 0; i<apparts.length; i++)
                {
                    apparts[i] = appartementsObjs.get(Integer.parseInt(s.split(">>")[1].split(";")[i].replace("A", "")));
                }
                Sauveteur.add(new Niveau(id, apparts));
            }
            int idBat = Integer.parseInt(strBat.split(">>")[0].replace("B", ""));
            Niveau[] nvx = new Niveau[niveauxObjs.values().size()];
            for(int i = 0; i<nvx.length; i++)
            {
                nvx[i] = niveauxObjs.get(Integer.parseInt(strBat.split(">>")[1].split(";")[i].replace("N","")));
            }
            MainProg.Batimentfinal = new Batiment(idBat, nvx);
//            
//            
//            //coins
//            for(String s : strObjets)
//            {
//                if(s.startsWith("C"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("C", ""));
//                    double x = Double.parseDouble((s.split(">>")[1].split(";")[0]));
//                    double y = Double.parseDouble((s.split(">>")[1].split(";")[1]));
//                    Sauveteur.add(new Coin(id,x,y));
//                }
//            }
//            //murs
//            for(String s : strObjets)
//            {
//                if(s.startsWith("M"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("M", ""));
//                    Coin c1 = (Coin)Sauveteur.get(s.split(">>")[1].split(";")[0]);
//                    Coin c2 = (Coin)Sauveteur.get(s.split(">>")[1].split(";")[1]);
//                    Revetement r = MagasinDeRevetements.getRevetement(s.split(">>")[1].split(";")[2]);
//                    PourMur[] lpm = new PourMur[s.split(">>")[1].split(";")[1].split("&").length];
//                    for(int i = 0; i<lpm.length; i++)
//                    {
//                        lpm[i] = MagasinDeRevetements.getPourMur(s.split(">>")[1].split(";")[1].split("&")[i]);
//                    }
//                    Sauveteur.add(new Mur(id, c1, c2, lpm));
//                }
//            }
//            //piece
//            for(String s : strObjets)
//            {
//                if(s.startsWith("Piece"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("Piece", ""));
//                    Mur m0 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[0]);
//                    Mur m1 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[1]);
//                    Mur m2 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[2]);
//                    Mur m3 = (Mur)Sauveteur.get(s.split(">>")[1].split(";")[3]);
//                    Piece p = new Piece(id, new Mur[]{m0, m1, m2, m3});
//                    
//                    int a = txtFichier.indexOf(s.split(">>")[1].split(";")[4] + ">>");
//                    int b = txtFichier.indexOf("/ ", a);
//                    String strSol = txtFichier.substring(a, b);
//                    int idSol = Integer.parseInt(strSol.split(">>")[0].replace("S", ""));
//                    PourSol[] lps = new PourSol[strSol.split(">>")[1].split(";")[1].split("&").length];
//                    for(int i = 0; i<lps.length; i++)
//                    {
//                        lps[i] = MagasinDeRevetements.getPourSol(strSol.split(">>")[1].split(";")[1].split("&")[i]);
//                    }
//                    Sol sol = new Sol(idSol, p, lps);
//                    
//                    a = txtFichier.indexOf(s.split(">>")[1].split(";")[5] + ">>");
//                    b = txtFichier.indexOf("/ ", a);
//                    String strPlaf = txtFichier.substring(a, b);
//                    int idPlaf = Integer.parseInt(strPlaf.split(">>")[0].replace("P", ""));
//                    PourPlafond[] lpp = new PourPlafond[strPlaf.split(">>")[1].split(";")[1].split("&").length];
//                    for(int i = 0; i<lpp.length; i++)
//                    {
//                        lpp[i] = MagasinDeRevetements.getPourPlafond(strSol.split(">>")[1].split(";")[1].split("&")[i]);
//                    }
//                    Plafond plaf = new Plafond(idPlaf, p, lpp);
//                    
//                    Sauveteur.add(p);
//                }
//            }
//            //appartements
//            for(String s : strObjets)
//            {
//                if(s.startsWith("A"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("A", ""));
//                    Piece[] pieces = new Piece[s.split(">>")[1].split(";").length - 1];
//                    for(int i = 0; i<pieces.length; i++)
//                    {
//                        pieces[i] = (Piece)Sauveteur.get(s.split(">>")[1].split(";")[i]);
//                    }
//                    String proprio = s.split(">>")[1].split(":")[1];
//                    Sauveteur.add(new Appartement(id, pieces, proprio));
//                }
//            }
//            //niveaux
//            for(String s : strObjets)
//            {
//                if(s.startsWith("N"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("N", ""));
//                    Appartement[] apparts = new Appartement[s.split(">>")[1].split(";").length];
//                    for(int i = 0; i<apparts.length; i++)
//                    {
//                        apparts[i] = (Appartement)Sauveteur.get(s.split(">>")[1].split(";")[i]);
//                    }
//                    Sauveteur.add(new Niveau(id, apparts));
//                }
//            }
//            //batiment
//            for(String s : strObjets)
//            {
//                if(s.startsWith("B"))
//                {
//                    int id = Integer.parseInt(s.split(">>")[0].replace("B", ""));
//                    Niveau[] nvx = new Niveau[s.split(">>")[1].split(";").length];
//                    for(int i = 0; i<nvx.length; i++)
//                    {
//                        nvx[i] = (Niveau)Sauveteur.get(s.split(">>")[1].split(";")[i]);
//                    }
//                    Sauveteur.add(new Batiment(id, nvx));
//                }
//            }
        }
        catch (IOException err)
        {
            System.out.println("Erreur :\n"+err);
        }
    }
}
