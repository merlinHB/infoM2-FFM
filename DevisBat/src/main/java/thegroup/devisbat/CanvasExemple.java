package thegroup.devisbat;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExemple extends Application {
    
    @Override
    public void start(Stage stage) {
        Scene sc = new Scene(new MainPane());
        stage.setScene(sc);
        stage.show();
            stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}