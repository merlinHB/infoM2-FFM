/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public class Carrelage extends Revetement{

    double cout;

    
    public Carrelage(int idrevetement, double surface, double prix) {
       super(idrevetement, surface, prix);
       cout = surface*prix;
       this.cout = surface*prix;
    }
}
    
    
    



