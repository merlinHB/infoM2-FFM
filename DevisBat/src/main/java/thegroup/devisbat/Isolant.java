package thegroup.devisbat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fscheer01
 */
public class Isolant extends Revetement {
    
    double cout;

public Isolant(int idrevetement, double surface, double prix) {
       super(idrevetement, surface, prix);
       cout = surface*prix;
       this.cout = surface*prix;
    }
}    

