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
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.InputEvent;
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
    
    private static double pixelsParMetre = 100;
    private static Point2D origine;//coos de l'origine reelle en coos ecran 
    private Point2D initPos;
    
    private double maxX = 512;
    private double maxY = 512;
    private ObservableList<Node> children;
    
    public DessinCanvas(){
        super();
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, eventClick);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, eventGlissed);
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, eventUnclicked);
        this.setMaxSize(maxX, maxY);
        children = getChildren();
        
        origine = new Point2D(256,256);
        
        Point2D extr1 = realToScreenPos(0,0);
        Point2D extr2 = realToScreenPos(100,0);
        Polygon r = new Polygon(extr1.getX(), extr1.getY(), extr2.getX(), extr2.getY());
        r.setFill(Color.BLACK);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(epaisseurTrait);
        children.add(r);
        //DessinRectangle(origine.x, origine.y, realToScreenPos(0.6, 1.2).x, realToScreenPos(0.6, 1.2).y, true);
        
        
        setStyle("-fx-background-color: #fff9ea");
    }
    
    public void DessinerCoinsPiece(Piece p)
    {
        for(Coin c : p.getCoins())
        {
            Point2D coo = realToScreenPos(c.getX(), c.getY());
            DessinPoint(coo.getX(), coo.getY());
        }
    }
    
    public void DessinPoint(double x, double y)
    {
        Circle c = new Circle(x,y,rayonPoint);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(epaisseurTrait);
        children.add(c);
    }
    
    public void DessinRectangle(double xa, double ya, double xz, double yz, boolean add)
    {
        double[] coos = {xa, ya,    xa, yz,     xz, yz,     xz, ya};
        PieceGraphique r = new PieceGraphique(coos);
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
    
    
    public static Point2D realToScreenPos(double x, double y)
    {
        Point2D coos = new Point2D(x, y);
        coos.multiply(pixelsParMetre);
        coos = new Point2D(coos.getX()+ origine.getX(), -coos.getY() + origine.getY());
        return coos;
    }
    
    public static Point2D screenToRealPos(double x, double y)
    {
        Point2D coos = new Point2D(x, y);
        coos = new Point2D(coos.getX() - origine.getX(), -coos.getY() - origine.getY());
        coos.multiply(1/pixelsParMetre);
        return coos;
    }
    
    EventHandler<MouseEvent> eventClick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            initPos = new Point2D(e.getX(), e.getY());
            switch(MainProg.mode) {
                case 'p':
                    DessinRectangle(initPos.getX(), initPos.getY(), e.getX(), e.getY(), true);
                    break;
                case 'm':
                    break;
                case 's':
                    for(Node n : children)
                    {
                        if(n.getClass() == PieceGraphique.class)
                        {
                            if(n.contains(e.getX(), e.getY()))
                            {
                                ((PieceGraphique)n).setStroke(Color.RED);
                                MainProg.layout.setRight(new Inspecteur(((PieceGraphique)n).piece));
                            }else{
                                ((PieceGraphique)n).setStroke(Color.BLACK);
                            }
                        }
                        
                    }
                    break;
                default:
                    break;
              }
        }
    };
    
    EventHandler<MouseEvent> eventGlissed = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            if(e.isMiddleButtonDown())
            {
                origine.add(e.getX() - initPos.getX(), e.getY() - initPos.getY());
                for(Node n : children)
                {
                    n.setTranslateX(e.getX() - initPos.getX());
                    n.setTranslateY(e.getY() - initPos.getY());
                }
                return;
            }
            
            double x = Double.max(0, Double.min(e.getX(), maxX));
            double y = Double.max(0, Double.min(e.getY(), maxY));
            switch(MainProg.mode) {
                case 'p':
                    DessinRectangle(initPos.getX(), initPos.getY(), x, y, false);
                    break;
                case 'm':
                    break;
                case 's':
                    break;
                default:
                    break;
              }
        }
    };
    
    
    EventHandler<MouseEvent> eventUnclicked = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            if(e.isMiddleButtonDown()){
                return;
            }
            switch(MainProg.mode) {
                case 'p':
                    ((PieceGraphique)children.get(children.size() - 1)).CreerPiece();
                    break;
                default:
                    break;
              }
        }
    };
}
