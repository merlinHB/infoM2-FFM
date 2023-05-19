/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import static thegroup.devisbat.MainProg.Batimentfinal;

/**
 *
 * @author mhibou01
 */
public class Labelrevetement extends HBox{
    
    Label totalrevetement = new Label("Cout total" + Batimentfinal.devisBatiment());
  
    public Labelrevetement(){
        
        Button UpdateRevetement = new Button("update Revetement");
        
        UpdateRevetement.setOnAction(update);
        
        
}
   EventHandler<ActionEvent> update = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            totalrevetement.setText("Cout total" + Batimentfinal.devisBatiment());
        }
    };
    
}
