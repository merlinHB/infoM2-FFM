package thegroup.devisbat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author fscheer01
 */
public class MainPane extends BorderPane {
    
    private RadioButton rbSelect;
    private RadioButton rbPoints;
    private RadioButton rbSegments;
    
    private Button bGrouper;
    private Button bCouleur;
    
    private Canvas cDessin;
    
    public MainPane() {
        this.rbSelect = new RadioButton("Select");
        this.rbPoints = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        
        VBox vbGauche = new VBox(this.rbSelect,this.rbPoints,this.rbSegments);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bCouleur = new Button("Couleur");
        VBox vbDroit = new VBox(this.bGrouper,this.bCouleur);
        this.setRight(vbDroit);
        
        this.cDessin = new Canvas(200, 200);
        this.setCenter(this.cDessin);

    }
    
}
