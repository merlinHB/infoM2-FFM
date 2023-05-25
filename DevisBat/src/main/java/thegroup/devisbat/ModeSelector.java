package thegroup.devisbat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        creerPiece.setPrefSize(80, 50);
        creerPiece.setOnAction(eventCreerPiece);
        
        Button appRevs = new Button("Appliquer\ndes revetements");
        appRevs.setPrefSize(80, 50);
        appRevs.setOnAction(eventRevPiece);
        
        Button ajustCoin = new Button("Ajuster\nles coins");
        ajustCoin.setPrefSize(80, 50);
        ajustCoin.setOnAction(eventselecPiece);
        
        fileName = new TextField();
        fileName.setPrefSize(120, 20);
        
        Button sauv = new Button("Sauvegarder");
        sauv.setPrefSize(120, 20);
        sauv.setOnAction(eventSauv);
        
//        openFileName = new TextField();
//        openFileName.setPrefSize(120, 20);
//        
//        Button ouvr = new Button("Sauvegarder");
//        ouvr.setPrefSize(120, 20);
//        ouvr.setOnAction(eventOuvrir);
        
        getChildren().add(creerPiece);
        getChildren().add(ajustCoin);
        getChildren().add(appRevs);
        getChildren().add(new VBox(fileName, sauv));
    }
    
    private TextField fileName;
    private TextField openFileName;
    
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
    
    EventHandler<ActionEvent> eventSauv = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.Sauvegarder(fileName.getText());
        }
    };
    
    EventHandler<ActionEvent> eventselecPiece = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            MainProg.mode = 's';
        }
    };
    
    EventHandler<ActionEvent> eventOuvrir = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            Sauveteur.Ouvrir(openFileName.getText()+".devis");
        }
    };
}
