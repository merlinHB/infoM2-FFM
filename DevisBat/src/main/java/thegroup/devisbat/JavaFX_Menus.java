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

public class JavaFX_Menus extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    Coin c1 = new Coin(0 ,0, 0, true);
    
    public static char mode = 'p';//p : creer piece, m : modifier piece, g : gomme
    
    public static DessinCanvas dc;
    
    public static BorderPane layout;
    
   

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batiment");
        
        
        layout = new BorderPane();
        
        NvSelector btnsNv = new NvSelector();
        layout.setLeft(btnsNv);
        
        ModeSelector ms = new ModeSelector();
        layout.setTop(ms);
        
        dc = new DessinCanvas();
        
        btnsNv.addNv(1);
        
        Scene scene = new Scene(layout, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
