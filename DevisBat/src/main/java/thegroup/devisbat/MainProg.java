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
    
    public static char mode = 'p';//p : creer piece, r : revetir la piece, s : selec pour coins
    public static int lastId = 0;
    
    public static BorderPane layout;
    
    public static Batiment Batimentfinal; 
    
    public static ArrayList<Piece> tempPieces = new ArrayList<Piece>();
   

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batiment");
        
        MagasinDeRevetements.LireRevetements();
        
        Batimentfinal = new Batiment();
        
        layout = new BorderPane();
        
        NvSelector btnsNv = new NvSelector();
        layout.setLeft(btnsNv);
        
        ModeSelector ms = new ModeSelector();
        layout.setTop(ms);
        
        
        btnsNv.addNv(1);
        
        Labelrevetement Labelle = new Labelrevetement();
        layout.setBottom(Labelle);
        
        Scene scene = new Scene(layout, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void Sauvegarder(String nomDuFichier)
    {
        Sauveteur.clear();
        for(Niveau n : Batimentfinal.getNiveaux())
        {
            for(Appartement a : n.getAppartements())
            {
                for(Piece p : a.getPieces())
                {
                    for(Mur m : p.getMurs())
                    {
                        Sauveteur.add(m.getC1());
                        Sauveteur.add(m.getC2());
                        Sauveteur.add(m);
                    }
                    Sauveteur.add(p.getSol());
                    Sauveteur.add(p.getPlafond());
                    Sauveteur.add(p);
                }
                Sauveteur.add(a);
            }
            Sauveteur.add(n);
        }
        Sauveteur.Enregister(nomDuFichier + ".devis");
    }
    
    public static int GenererId()
    {
        lastId += 1;
        return lastId;
    }
}
