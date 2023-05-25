/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import static java.lang.Math.round;
import static java.lang.StrictMath.round;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import static thegroup.devisbat.MainProg.Batimentfinal;

/**
 *
 * @author mhibou01
 */
public class Labelrevetement extends HBox{
    
    Label totalrevetement = new Label("Cout total " + Math.round(MainProg.Batimentfinal.devisBatiment()) + " €");
    
  
    public Labelrevetement(){
        
        Button UpdateRevetement = new Button("Recalculer le devis");
        UpdateRevetement.setPrefSize(150, 25);
        setSpacing(10);
        UpdateRevetement.setOnAction(update);
        
        getChildren().add(UpdateRevetement);
        getChildren().add(totalrevetement);
        getChildren().add(new Line(0,0,DessinCanvas.getPxsParMetre(),0));
        getChildren().add(new Label("1 m"));
    }
    
   EventHandler<ActionEvent> update = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            totalrevetement.setText("Cout total " + Math.round(MainProg.Batimentfinal.devisBatiment()) + " €");
        }
    };
    
}
