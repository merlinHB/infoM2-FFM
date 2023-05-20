/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

/**
 *
 * @author fplumet01
 */
public class Inspecteur extends VBox{
    public Inspecteur(Piece piece, DessinCanvas dc)
    {
        this.piece = piece;
        this.dc = dc;
        
        setPadding(new Insets(2, 2, 4, 4));
        setSpacing(10);
        
        for(Coin c: piece.getCoins())
        {
            Label txt = new Label("Coin " + c.getId());
            txt.setPrefSize(60, 20);
            TextField x = new TextField(c.getX() + "");
            x.setPrefSize(40, 20);
            TextField y = new TextField(c.getY() + "");
            x.setPrefSize(40, 20);
            //txt.setOnAction(eventEntree);
            getChildren().add(txt);
            getChildren().add(x);
            getChildren().add(y);
       
            x.addEventHandler(KeyEvent.KEY_PRESSED, eventkeyEnter);
            y.addEventHandler(KeyEvent.KEY_PRESSED, eventkeyEnter);
        }
    }
    public Inspecteur(Piece piece)
    {
        this.piece = piece;
        
        
        setPadding(new Insets(4, 4, 4, 4));
        setSpacing(10);
        
        
        for(Mur m: piece.getMurs())
        {
            Label txt = new Label("Mur " + m.getId());
            txt.setPrefSize(60, 20);
            txt.setFont(new Font(15));
            
            VBox revsContainer = new VBox();
            for(PourMur pm : m.getRevetements())
            {
                revsContainer.getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
            }
            
            ComboBox revDD = new ComboBox();
            for(PourMur pm : MagasinDeRevetements.getPourMurs())
            {
                revDD.getItems().add(pm.getNom()+" : "+pm.getPrix()+" €/m²");
            }
            revDD.setPromptText("Ajoutez un revetement");
            revDD.addEventHandler(ActionEvent.ACTION, eventMur);
            getChildren().add(txt);
            getChildren().add(revsContainer);
            getChildren().add(revDD);
        }
    }
    EventHandler <KeyEvent> eventkeyEnter = new EventHandler <KeyEvent>() {
        public void handle(KeyEvent event){
            if ((event.getCode()) != (KeyCode.ENTER)) 
            {
                return;
            }
            TextField txt = (TextField)event.getTarget();
            int id = getChildren().indexOf(txt)/3;
            double x = Double.parseDouble(((TextField)getChildren().get(id*3+1)).getText());
            double y = Double.parseDouble(((TextField)getChildren().get(id*3+2)).getText());
            Piece cepie = piece;
            piece.setCoin(id, x, y);
            dc.UpdatePoly(cepie, piece);
        }         
    };
    EventHandler <ActionEvent> eventMur = new EventHandler <ActionEvent>() {
        public void handle(ActionEvent e){
            ComboBox c = (ComboBox)e.getTarget();
            int id = getChildren().indexOf(c)/2;
            String value = c.getValue().toString();
            piece.getMur(id).addRevetement(value.split(" : ")[0]);
            PourMur pm = MagasinDeRevetements.getPourMur(value.split(" : ")[0]);
            ((VBox)getChildren().get(id)).getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
            System.out.println(piece.getMur(id));
        }         
    };
            
            
    private Piece piece;
    private DessinCanvas dc;
   
           
}
    


   
 

