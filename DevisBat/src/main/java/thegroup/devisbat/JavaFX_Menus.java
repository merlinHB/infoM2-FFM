package  thegroup.devisbat;



/**
 * JavaFX App
 */
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

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batiment");
        
        
        BorderPane layout = new BorderPane();
        
        NvSelector btnsNv = new NvSelector();
        layout.setLeft(btnsNv);
        
        ModeSelector ms = new ModeSelector();
        layout.setTop(ms);
        
        dc = new DessinCanvas(512,512);
        GraphicsContext gc = dc.getGraphicsContext2D();
        gc.strokeRect(0, 0, dc.getWidth(), dc.getHeight());
        layout.setCenter(dc);
        
        
        Scene scene = new Scene(layout, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}