package thegroup.devisbat;


public class DevisBat {

    public static void main(String[] args) 
    {
        //test revetements
        MagasinDeRevetements.LireRevetements();
        
        System.out.println("\n/***Début du programme de test***/\n");
        
        
        
        //test trucs de base
        Coin c1 = new Coin(0,0,0);
        Coin c3 = new Coin(2, 5, 10);
        Coin c2 = new Coin(1, c1.getX(), c3.getY());
        Coin c4 = new Coin(3, c3.getX(), c1.getY());
        Coin c5 = new Coin(4, c3.getX(), 5);
        
        
        Mur m1 = new Mur(10, c1, c2);
        Mur m2 = new Mur(11, c2, c3);
        Mur m3 = new Mur(12, c3, c5);
        Mur m4 = new Mur(13, c5, c4);
        Mur m5 = new Mur(14, c4, c1);
        
        Piece p1 = new Piece(0, new Mur[]{m1, m2, m3, m4, m5});
        Sol s1 = new Sol(p1);
        s1.addRevetement("Carrelage");
        Plafond plaf1 = new Plafond(p1);
        for(int i = 0; i<p1.nbrMurs(); i++)
        {
            System.out.println("mur " + i + " : " + p1.getMur(i));
            System.out.println("coin " + i + " : " + p1.getCoin(i));
        }
        p1.setCoin(2, 6, 11);
        for(int i = 0; i<p1.nbrMurs(); i++)
        {
            System.out.println("mur " + i + " : " + p1.getMur(i));
            System.out.println("coin " + i + " : " + p1.getCoin(i));
        }
        System.out.println("surface : " + p1.surfacePiece());
        Sauveteur.Enregister("Enregistrement.devisEnregistre");
    }
}
