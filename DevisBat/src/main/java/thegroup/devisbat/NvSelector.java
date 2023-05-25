package thegroup.devisbat;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;

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
    }
    
    private Button nvNvBtn;
    public static ArrayList<DessinCanvas> listeCanvas = new ArrayList<DessinCanvas>();
  
    
    //listeCanvas.add(MainProg.dc);
    
    public void addNv(int num)
    {
        Button nvnv = new Button("Niveau" + num);
        nvnv.setPrefSize(100, 50);
        nvnv.setOnAction(eventNvClicked);
        getChildren().add(0, nvnv);
        
        DessinCanvas niveau = new DessinCanvas(listeCanvas.size());
        listeCanvas.add(0, niveau);
        MainProg.Batimentfinal.addNiveau(new Niveau(MainProg.Batimentfinal.isImmeuble()));
        
        goToNv(num, 0);
    }
    
    public void goToNv(int num, int idNv)
    {
        MainProg.layout.setCenter(listeCanvas.get(idNv));
    }
    
    EventHandler<ActionEvent> eventNvNv = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            addNv(getChildren().size());
            MainProg.Batimentfinal.addNiveau(new Niveau(MainProg.Batimentfinal.isImmeuble()));
        }
    };
    
    EventHandler<ActionEvent> eventNvClicked = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            goToNv(getChildren().size() - getChildren().indexOf(e.getSource()) - 1, getChildren().indexOf(e.getSource()));
        }
    };
}
