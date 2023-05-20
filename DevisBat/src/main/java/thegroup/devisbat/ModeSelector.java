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
        
        Button appRevs = new Button("Appliquer\ndes revetements");
        appRevs.setPrefSize(80, 40);
        appRevs.setOnAction(eventRevPiece);
        
        Button ajustCoin = new Button("Ajuster\nles coins");
        ajustCoin.setPrefSize(80, 40);
        ajustCoin.setOnAction(eventselecPiece);
        
        super.getChildren().add(creerPiece);
        super.getChildren().add(ajustCoin);
        super.getChildren().add(appRevs);
    }
    
    EventHandler<ActionEvent> eventRevPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 'r';
        }
    };
    EventHandler<ActionEvent> eventCreerPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 'p';
        }
    };
    
    EventHandler<ActionEvent> eventselecPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 's';
        }
    };
}
