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
    public static double scrollSensi = 0.5;
    
    private static double pixelsParMetre = 100;
    private static Point2D origine = Point2D.ZERO;//coos de l'origine reelle en coos ecran 
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
        
        origine = new Point2D(256,256);
        
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
    
    public void CreerPiece(int id, double xa, double ya, double xz, double yz)
    {
        ArrayList<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(MainProg.GenererId(), xa, ya));
        coins.add(new Coin(MainProg.GenererId(), xa, yz));
        coins.add(new Coin(MainProg.GenererId(), xz, yz));
        coins.add(new Coin(MainProg.GenererId(), xz, ya));
        MainProg.tempPieces.add(new Piece(id, (Coin[])coins.toArray()));
    }
//    public void CreerPiece(int id, double xa, double ya, double xz, double yz, int idDansListe)
//    {
//        ArrayList<Coin> coins = new ArrayList<Coin>();
//        coins.add(new Coin(MainProg.GenererId(), xa, ya));
//        coins.add(new Coin(MainProg.GenererId(), xa, yz));
//        coins.add(new Coin(MainProg.GenererId(), xz, yz));
//        coins.add(new Coin(MainProg.GenererId(), xz, ya));
//        MainProg.tempPieces.set(idDansListe, new Piece(id, (Coin[])coins.toArray()));
//    }
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
    
    public Point2D realToScreenPos(double x, double y)
    {
        Point2D coos = new Point2D(x, y);
        coos.multiply(pixelsParMetre);
        coos.add(origine);
        return coos;
    }
    
    public Point2D screenToRealPos(double x, double y)
    {
        Point2D coos = new Point2D(x, y);
        coos.subtract(origine);
        coos.multiply(1/pixelsParMetre);
        return coos;
    }
    
    EventHandler<MouseEvent> eventClick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            switch(MainProg.mode) {
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
            switch(MainProg.mode) {
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
            pixelsParMetre += e.getDeltaY() * scrollSensi;
        }
    };
}
