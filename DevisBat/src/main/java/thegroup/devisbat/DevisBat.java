package thegroup.devisbat;

public class DevisBat {

    public static void main(String[] args) {
        
        Coin c = new Coin(0,0,0);
        System.out.println(c);
        SaveClass.coins.add(c);
        SaveClass.Enregister();
    }
}
