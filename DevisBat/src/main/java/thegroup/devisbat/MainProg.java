package  thegroup.devisbat;



/**
 * JavaFX App
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainProg extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    public static char mode = 'p';//p : creer piece, m : modifier piece, g : gomme
    public static int lastId = 0;
    
    public static BorderPane layout;
    
    public static ArrayList<Piece> tempPieces = new ArrayList<Piece>();
   

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batiment");
        
        
        layout = new BorderPane();
        
        NvSelector btnsNv = new NvSelector();
        layout.setLeft(btnsNv);
        
        ModeSelector ms = new ModeSelector();
        layout.setTop(ms);
        
        
        btnsNv.addNv(1);
        
        Scene scene = new Scene(layout, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static int GenererId()
    {
        lastId += 1;
        return lastId;
    }
}
