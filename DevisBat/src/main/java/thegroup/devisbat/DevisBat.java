package thegroup.devisbat;

public class DevisBat {

    public static void main(String[] args) 
    {
        //test revetements
        MagasinDeRevetements.LireRevetements();
        
        System.out.println("/***Début du programme de test***/");
        
        Carrelage carrelage = MagasinDeRevetements.getCarrelage("Carrelage carre");
        System.out.println(carrelage + ", " + carrelage.getId());
        
        System.out.println(MagasinDeRevetements.getRevetement(3));
        System.out.println(MagasinDeRevetements.getRevetement("Rouge"));
        
        
        //test trucs de base
        System.out.println("coordonnées du coin 1 : (0;0)");
        Coin c1 = new Coin(0,0,0);
        System.out.println("coordonnées du coin opposé (coin 3/diagonale)");
        Coin c3 = new Coin(2, Lire.d(), Lire.d());
        Coin c2 = new Coin(1, c1.getX(), c3.getY());
        Coin c4 = new Coin(3, c3.getX(), c1.getY());
        System.out.println("coin 2 : " + c2);
        System.out.println("coin 4 : " + c4);
        
        Revetement[] revs = MagasinDeRevetements.getListeDeRevetement();
        for(Revetement r : revs)
        {
            System.out.println(r);
        }
        System.out.println("revetement des murs 1, 2, 3 et 4");
        Mur m1 = new Mur(0, c1, c2, revs[Lire.choix(revs.length) - 1]);
        Mur m2 = new Mur(1, c2, c3, revs[Lire.choix(revs.length) - 1]);
        Mur m3 = new Mur(2, c3, c4, revs[Lire.choix(revs.length) - 1]);
        Mur m4 = new Mur(3, c4, c1, revs[Lire.choix(revs.length) - 1]);
        System.out.println("Le mur 1 fait " + m1.longueur() + " de long, et coute " + m1.cout() + "euros");
        
        Piece p1 = new Piece(0, new Mur[]{m1, m2, m3, m4}, new Coin[]{c1, c2, c3, c4});
        Sol s1 = new Sol(0, p1, MagasinDeRevetements.getCarrelage("Test"));
        System.out.println("revetement du plafond");
        Plafond plaf1 = new Plafond(0, p1, revs[Lire.choix(revs.length) - 1]);
        p1.setSol(s1);
        p1.setPlafond(plaf1);
        Sauveteur.add(p1);
        System.out.println("Le plafond coute " + plaf1.cout() + "euros (surface :" + p1.surfacePiece() + "m2)");
        System.out.println("Piece p1 créée : " + p1);
        System.out.println("La piece coute " + p1.devisPiece() + "euros");
        
        
        Sauveteur.Enregister("Enregistrement.devisEnregistre");
    }
}
