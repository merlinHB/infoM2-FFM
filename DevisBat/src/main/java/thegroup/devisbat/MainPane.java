package thegroup.devisbat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

/**
 *
 * @author fscheer01
 */
public class MainPane extends BorderPane {
    
    private Button coin;
    private Button mur;
    private Button piece;
    
    
    private Button bGrouper;
    private Button bCouleur;
    
    private DessinCanvas cDessin;
    
    public MainPane() {
        this.coin = new Button("Coin");
        this.mur = new Button("Mur");
        this.piece = new Button("Piece");
        
        
       
        
        HBox bTop = new HBox(this.coin, this.mur, this.piece);
        this.setTop(bTop);
        
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler <ActionEvent> () {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("bouton grouper cliqué");
            }
                
        });
        this.bCouleur = new Button("Couleur");
        VBox vbDroit = new VBox(this.bGrouper,this.bCouleur);
        this.setRight(vbDroit);
        
        this.cDessin = new DessinCanvas(500, 500);
        this.setCenter(this.cDessin);

    }
    
}
