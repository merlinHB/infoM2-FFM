package thegroup.devisbat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
/**
 *
 * @author fplumet01
 */
public class ModeSelector extends HBox{
    public ModeSelector()
    {
        super();
        
        setPadding(new Insets(2, 2, 2, 2));
        setSpacing(10);
           
        Button creerPiece = new Button("Creer piece");
        creerPiece.setPrefSize(80, 40);
        creerPiece.setOnAction(eventCreerPiece);
        
//        Button modPiece = new Button("Modifier\npiece");
//        modPiece.setPrefSize(80, 40);
//        modPiece.setOnAction(eventModPiece);
        
        Button gomme = new Button("Selection\nPiece");
        gomme.setPrefSize(80, 40);
        gomme.setOnAction(eventselecPiece);
        
        super.getChildren().add(creerPiece);
        //super.getChildren().add(modPiece);
        super.getChildren().add(gomme);
    }
    
    EventHandler<ActionEvent> eventCreerPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 'p';
        }
    };
    
    EventHandler<ActionEvent> eventModPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 'm';
        }
    };
    
    EventHandler<ActionEvent> eventselecPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 's';
        }
    };
}
