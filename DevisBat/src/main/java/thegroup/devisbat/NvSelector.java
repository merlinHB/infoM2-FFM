package thegroup.devisbat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mhibou01
 */
public class NvSelector extends VBox{
    public NvSelector()
    {
        super();
        
        setPadding(new Insets(2, 2, 2, 2));
        setSpacing(10);

        nvNvBtn = new Button(" + ");
        nvNvBtn.setPrefSize(100, 50);
        nvNvBtn.setOnAction(eventNvNv);
        
        super.getChildren().add(nvNvBtn);
        addBtnNv("Niveau 1");
    }
    
    private Button nvNvBtn;
    
    public void addBtnNv(String txt)
    {
        Button nvnv = new Button(txt);
        nvnv.setPrefSize(100, 50);
        nvnv.setOnAction(eventNvClicked);
        getChildren().add(0, nvnv);
    }
    
    EventHandler<ActionEvent> eventNvNv = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            addBtnNv("Niveau " + getChildren().size());
        }
    };
    
    EventHandler<ActionEvent> eventNvClicked = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            System.out.println("Bouton nv " + (getChildren().size() - getChildren().indexOf(e.getSource()) - 1));
        }
    };
}
