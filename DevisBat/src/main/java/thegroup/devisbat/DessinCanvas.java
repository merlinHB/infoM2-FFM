/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 *
 * @author mhibou01
 */
public class DessinCanvas extends Pane{
    
    public static double rayonPoint = 5;
    public static double epaisseurTrait = 2;
    public static double scrollSensi = 0.01;
    
    private double zoom;
    private double[] initPos;
    
    private double maxX = 512;
    private double maxY = 512;
    private ObservableList<Node> children;
    
    public DessinCanvas(){
        super();
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, eventClick);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, eventGlissed);
        this.addEventHandler(ScrollEvent.SCROLL, eventScrolled);
        this.setMaxSize(maxX, maxY);
        children = getChildren();
        
        DessinRectangle(0,0,maxX,maxY,true);
        
        setStyle("-fx-background-color: #fff9ea");
    }
    
    public void DessinPoint(double x, double y)
    {
        gc.strokeOval(x - rayonPoint, y - rayonPoint, rayonPoint*2, rayonPoint*2);
    }
    
    public void DessinRectangle(double xa, double ya, double xz, double yz, boolean add)
    {
        double[] coos = {xa, ya,    xa, yz,     xz, yz,     xz, ya};
        for(double d : coos)
        {
            d *= zoom;
        }
        Polygon r = new Polygon(coos);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(epaisseurTrait);
        if(add)
        {
            children.add(r);
        }else{
            children.set(children.size() - 1, r);
        }
    }
//    
//    public void DessinRectangle(double xa, double ya, double xz, double yz, int id)
//    {
//        Polygon r = new Polygon(new double[]{xa, ya,    xa, yz,     xz, yz,     xz, ya});
//        r.setFill(Color.TRANSPARENT);
//        r.setStroke(Color.BLACK);
//        r.setStrokeWidth(epaisseurTrait);
//        children.set(id, r);
//    }
    
    public void Gomme(double x, double y)
    {
        
    }
    
    EventHandler<MouseEvent> eventClick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            switch(JavaFX_Menus.mode) {
                case 'p':
                    initPos = new double[]{e.getX(), e.getY()};
                    DessinRectangle(initPos[0], initPos[1], e.getX(), e.getY(), true);
                    break;
                case 'm':
                    initPos = new double[]{e.getX(), e.getY()};
                    break;
                case 'g':
                    Gomme(e.getX(), e.getY());
                    break;
                default:
                    break;
              }
        }
    };
    
    EventHandler<MouseEvent> eventGlissed = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            double x = Double.max(0, Double.min(e.getX(), maxX));
            double y = Double.max(0, Double.min(e.getY(), maxY));
            switch(JavaFX_Menus.mode) {
                case 'p':
                    DessinRectangle(initPos[0], initPos[1], x, y, false);
                    break;
                case 'm':
//                    int i =0;
//                    while(!children.get(i).contains(e.getX(), e.getY()))
//                    {
//                        i++;
//                    }
//                    DessinRectangle(initPos[0], initPos[1], e.getX(), e.getY(), i);
                    break;
                case 'g':
                    Gomme(e.getX(), e.getY());
                    break;
                default:
                    break;
              }

            
        }
    };
    
    EventHandler<ScrollEvent> eventScrolled = new EventHandler<ScrollEvent>() {
        public void handle(ScrollEvent e)
        {
            zoom += e.getDeltaY() * scrollSensi;
            System.out.println(zoom);
        }
    };
}
