package  thegroup.devisbat;



/**
 * JavaFX App
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class JavaFX_Menus extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batiment");

        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Création");
        Menu menu2 = new Menu("Gestion");
        Menu menu3 = new Menu("Aide");
        Menu menu4 = new Menu("Documentation");
        MenuItem menuItem1 = new MenuItem("Coin");
        MenuItem menuItem2 = new MenuItem("Mur");
        MenuItem menuItem3 = new MenuItem("Niveau");
        MenuItem menuItem4 = new MenuItem("Pièce");
        //SeparatorMenuItem separator = new SeparatorMenuItem();
        // Ajout des items dans un menu
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        menu1.getItems().add(menuItem4);

        // Mise écoute un Item de menu
        menuItem1.setOnAction(e -> {
        System.out.println("Créer un Coin");
        });
        menuItem2.setOnAction(e -> {
        System.out.println("Créer un Mur");
        });
        
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.getMenus().add(menu4);
        
        Canvas canvas = new Canvas();
        canvas.setHeight(512);
        canvas.setWidth(512);
        
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();

        graphicsContext2D.setFill(Color.valueOf("#ff0000"));
        graphicsContext2D.fillRect(100, 100, 200, 200);

        graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
        graphicsContext2D.strokeRect(200, 200, 200, 200);

        

        VBox vBox = new VBox(menuBar, canvas);
       // VBox vBox2 = new VBox(canvas);
// File Chooser
    FileChooser fileChooser = new FileChooser();
        
        Scene scene = new Scene(vBox, 960, 600);
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}