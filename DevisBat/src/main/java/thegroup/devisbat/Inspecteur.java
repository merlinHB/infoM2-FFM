/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author fplumet01
 */
public class Inspecteur extends VBox{
    public Inspecteur(Piece piece)
    {
        this.piece = piece;
        
        setPadding(new Insets(2, 2, 4, 4));
        setSpacing(10);
        
        for(Coin c: piece.getCoins())
        {
            Label txt = new Label("Coin " + c.getId());
            txt.setPrefSize(60, 20);
            TextField x = new TextField(c.getX() + " ");
            x.setPrefSize(40, 20);
            TextField y = new TextField(c.getY() + " ");
            x.setPrefSize(40, 20);
            //txt.setOnAction(eventEntree);
            getChildren().add(txt);
            getChildren().add(x);
            getChildren().add(y);
       
            x.addEventHandler(KeyEvent.KEY_PRESSED, eventkeyEnter);
            
            

        
        };
        
        
        
     
    }
            EventHandler <KeyEvent> eventkeyEnter = new EventHandler <KeyEvent>() {
            public void handle(KeyEvent event){
            if ((event.getCode()) != (KeyCode.ENTER)) {
                return;
                }
                TextField x = (TextField)event.getTarget();
                x.setText(x.getText());
            }
                
            };
            
            
            private Piece piece;
   
           
        }
    


   
 

