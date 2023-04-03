package thegroup.devisbat;

public class DevisBat {

    public static void main(String[] args) {
        
        Coin c = new Coin(0,0,0);
        System.out.println(c);
        SaveClass.coins.add(c);
        SaveClass.Enregister();
        
       //Coin c1 = new Coin(1, 0, 200);
       //Coin c2 = new Coin(2, 0, 150);
       
       //System.out.println(Coin.DistanceEntre(c1, c2));
       
       
       
    }
}
