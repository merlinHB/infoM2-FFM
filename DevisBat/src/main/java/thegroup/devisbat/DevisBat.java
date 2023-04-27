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
        Coin c1 = new Coin(0,0,0, true);
        System.out.println("coordonnées du coin opposé (coin 3/diagonale)");
        Coin c3 = new Coin(2, Lire.d(), Lire.d(), true);
        Coin c2 = new Coin(1, c1.getX(), c3.getY(), true);
        Coin c4 = new Coin(3, c3.getX(), c1.getY(), true);
        System.out.println("coin 2 : " + c2);
        System.out.println("coin 4 : " + c4);
        
        Revetement[] revs = MagasinDeRevetements.getListeDeRevetement();
        
        Mur m1 = new Mur(0, c1, c2, revs[4], true);
        Mur m2 = new Mur(1, c2, c3, revs[4], true);
        Mur m3 = new Mur(2, c3, c4, revs[4], true);
        Mur m4 = new Mur(3, c4, c1, revs[4], true);
        
        Piece p1 = new Piece(0, new Mur[]{m1, m2, m3, m4});
        Sol s1 = new Sol(0, p1, MagasinDeRevetements.getCarrelage("Test"), true);
        Plafond plaf1 = new Plafond(0, p1, revs[4], true);
        p1.setSol(s1);
        p1.setPlafond(plaf1);
        Sauveteur.add(p1);
        
        
        Sauveteur.Enregister("Enregistrement.devisEnregistre");
        
        p1.setCoin(0, new Coin(5, 8, 9));
        
        System.out.println("Le plafond coute " + plaf1.cout() + "euros (surface :" + p1.surfacePiece() + "m2)");
        System.out.println("Piece p1 créée : " + p1);
        System.out.println("La piece coute " + p1.devisPiece() + "euros");
        
        Sauveteur.Enregister("Enregistrement.devisEnregistre");
    }
}
