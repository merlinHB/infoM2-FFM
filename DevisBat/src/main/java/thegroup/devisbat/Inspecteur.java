/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.lblSol to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
//            lblSol.addEventHandler(MouseEvent.MOUSE_MOVED, eventHover);
        }
    }
    public Inspecteur(Piece piece, DessinCanvas dc, boolean revetement)
    {
        this.piece = piece;
        this.dc = dc;
        
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
        
        Label lblSol = new Label("Sol " + piece.getSol().getId());
        lblSol.setPrefSize(60, 20);
        lblSol.setFont(new Font(15));
            
        VBox revsContainerSol = new VBox();
        for(PourSol pm : piece.getSol().getRevetements())
        {
            revsContainerSol.getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
        }
        
        ComboBox revDDSol = new ComboBox();
        for(PourSol pm : MagasinDeRevetements.getPourSols())
        {
            revDDSol.getItems().add(pm.getNom()+" : "+pm.getPrix()+" €/m²");
        }
        revDDSol.setPromptText("Ajoutez un revetement");
        revDDSol.addEventHandler(ActionEvent.ACTION, eventSol);
        getChildren().add(lblSol);
        getChildren().add(revsContainerSol);
        getChildren().add(revDDSol);
        
        Label lblPlaf = new Label("Plafond " + piece.getPlafond().getId());
        lblPlaf.setPrefSize(60, 20);
        lblPlaf.setFont(new Font(15));
            
        VBox revsContainerPlaf = new VBox();
        for(PourPlafond pm : piece.getPlafond().getRevetements())
        {
            revsContainerPlaf.getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
        }
        
        ComboBox revDDPlaf = new ComboBox();
        for(PourSol pm : MagasinDeRevetements.getPourSols())
        {
            revDDPlaf.getItems().add(pm.getNom()+" : "+pm.getPrix()+" €/m²");
        }
        revDDPlaf.setPromptText("Ajoutez un revetement");
        revDDPlaf.addEventHandler(ActionEvent.ACTION, eventPlaf);
        getChildren().add(lblPlaf);
        getChildren().add(revsContainerPlaf);
        getChildren().add(revDDPlaf);
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
            int id = getChildren().indexOf(c)/3;
            String value = c.getValue().toString();
            piece.getMur(id).addRevetement(value.split(" : ")[0]);
            PourMur pm = MagasinDeRevetements.getPourMur(value.split(" : ")[0]);
            ((VBox)getChildren().get(getChildren().indexOf(c)-1)).getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
        }         
    };
    
    EventHandler <ActionEvent> eventSol = new EventHandler <ActionEvent>() {
        public void handle(ActionEvent e){
            ComboBox c = (ComboBox)e.getTarget();
            String value = c.getValue().toString();
            piece.getSol().addRevetement(value.split(" : ")[0]);
            PourSol pm = MagasinDeRevetements.getPourSol(value.split(" : ")[0]);
            ((VBox)getChildren().get(getChildren().indexOf(c)-1)).getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
        }         
    };
    
    EventHandler <ActionEvent> eventPlaf = new EventHandler <ActionEvent>() {
        public void handle(ActionEvent e){
            ComboBox c = (ComboBox)e.getTarget();
            String value = c.getValue().toString();
            piece.getPlafond().addRevetement(value.split(" : ")[0]);
            PourPlafond pm = MagasinDeRevetements.getPourPlafond(value.split(" : ")[0]);
            ((VBox)getChildren().get(getChildren().indexOf(c)-1)).getChildren().add(new Label(pm.getNom()+" : "+pm.getPrix()+" €/m²"));
        }         
    };
            
            
    private Piece piece;
    private DessinCanvas dc;
   
           
}
    


   
 

