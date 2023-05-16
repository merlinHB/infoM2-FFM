/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import java.util.Arrays;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mhibou01
 */
public class DessinCanvas extends Canvas{
    
    public double rayonPoint = 5;
    public double tailleGomme = 20;
    
    private double[] initPos;
    
    GraphicsContext gc;
    
    public DessinCanvas(double w, double h){
        super(w,h);
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, eventClick);
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, eventUnclick);
        gc = getGraphicsContext2D();
    }
    
    public void DessinPoint(double x, double y)
    {
        gc.strokeOval(x - rayonPoint, y - rayonPoint, rayonPoint*2, rayonPoint*2);
    }
    
    public void Gomme(double x, double y)
    {
        gc.fillRect(x - tailleGomme, y - tailleGomme, tailleGomme*2, tailleGomme*2);
        gc.clearRect(x - tailleGomme, y - tailleGomme, tailleGomme*2, tailleGomme*2);
    }
    
    EventHandler<MouseEvent> eventClick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            switch(JavaFX_Menus.mode) {
                case 'p':
                    initPos = new double[]{e.getX(), e.getY()};
                    System.out.println(Arrays.toString(initPos));
                    break;
                case 'm':
                    DessinPoint(e.getX(), e.getY());
                    break;
                case 'g':
                    Gomme(e.getX(), e.getY());
                    break;
                default:
                  // code block
              }

            
        }
    };
    
    EventHandler<MouseEvent> eventGlissed = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            switch(JavaFX_Menus.mode) {
                case 'p':
                    //;
                    break;
                case 'm':
                    DessinPoint(e.getX(), e.getY());
                    break;
                case 'g':
                    Gomme(e.getX(), e.getY());
                    break;
                default:
                  // code block
              }

            
        }
    };
    
    EventHandler<MouseEvent> eventUnclick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            switch(JavaFX_Menus.mode) {
                case 'p':
                    System.out.println(Arrays.toString(initPos) + "fin");
                    gc.strokeRect(initPos[0], initPos[1], Math.abs(initPos[0] - e.getX()), Math.abs(initPos[1] - e.getY()));
                    break;
                case 'm':
                    DessinPoint(e.getX(), e.getY());
                    break;
                case 'g':
                    Gomme(e.getX(), e.getY());
                    break;
                default:
                  // code block
              }

            
        }
    };
}
