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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

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
    
    private DessinCanvas cDessin;
    
    public MainPane() {
        this.rbSelect = new RadioButton("Select");
        this.rbPoints = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Création");
        Menu menu2 = new Menu("Gestion");
        Menu menu3 = new Menu("Aide");
        Menu menu4 = new Menu("Documentation");
        MenuItem menuItem1 = new MenuItem("Coin");
        MenuItem menuItem2 = new MenuItem("Mur");
        MenuItem menuItem3 = new MenuItem("Niveau");
        MenuItem menuItem4 = new MenuItem("Pièce");
        //SeparatorMenuItem separator = new SeparatorMenuItem();
        // Ajout des items dans un menu
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        menu1.getItems().add(menuItem4);
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.getMenus().add(menu4);
        
        VBox vbGauche = new VBox(menuBar);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bCouleur = new Button("Couleur");
        VBox vbDroit = new VBox(this.bGrouper,this.bCouleur);
        this.setRight(vbDroit);
        
        this.cDessin = new DessinCanvas(500, 500);
        this.setCenter(this.cDessin);

    }
    
}
