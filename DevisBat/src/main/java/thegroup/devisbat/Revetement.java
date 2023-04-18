/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

/**
 *
 * @author mhibou01
 */
public class Revetement {
    
    protected int idrevetement;
    protected double surface;
    protected double prix;
    protected double cout;
    
    public Revetement(int idrevetement, double surface, double prix) {
        this.idrevetement = idrevetement;
        this.surface = surface;
        this.prix = prix;
        cout = surface*prix;
        this.cout = surface*prix;
    }
    
}
