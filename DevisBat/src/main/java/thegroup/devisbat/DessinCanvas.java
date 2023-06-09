/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegroup.devisbat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
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
    
    private static double pixelsParMetre = 25;
    private Point2D origine;//coos de l'origine reelle en coos ecran 
    private Point2D initPos;
    private Point2D prevPos;
    
    private double maxX = 512;
    private double maxY = 512;
    private ObservableList<Node> children;
    private HashMap<Node, Piece> pieces;
    private DessinCanvas thisDC;
    private int niveau;
    
    public DessinCanvas(int nv){
        super();
        this.niveau = nv;
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, eventClick);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, eventGlissed);
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, eventUnclicked);
        this.setMaxSize(maxX, maxY);
        children = getChildren();
        pieces = new HashMap<Node, Piece>();
        thisDC = this;
        
        origine = new Point2D(0,0);
        
        DessinPoint(0,0, Color.BLACK);
        
        setStyle("-fx-background-color: #fff9ea");
    }
    
    public static double getPxsParMetre()
    {
        return pixelsParMetre;
    }
    
    public void UpdatePoly(Piece ancienne, Piece nouvelle)
    {
        double[] coos = new double[nouvelle.nbrMurs()*2];
        for(int i = 0; i<nouvelle.nbrMurs(); i++)
        {
            Point2D coo = realToScreenPos(nouvelle.getCoin(i).getX(), nouvelle.getCoin(i).getY());
            coos[i*2] = coo.getX();
            coos[i*2+1] = coo.getY();
        }
        for(Node n : pieces.keySet())
        {
            if(ancienne == pieces.get(n))
            {
                Polygon p = PolygonParametre(coos);
                pieces.remove(n);
                pieces.put(p, nouvelle);
                children.remove(n);
                children.add(p);
                return;
            }
        }
    }
    
    public Circle DessinPoint(double x, double y, Color color)
    {
        Circle c = new Circle(realToScreenPos(x,y).getX(),realToScreenPos(x,y).getY(),rayonPoint);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(color);
        c.setStrokeWidth(epaisseurTrait);
        children.add(c);
        return c;
    }
    
    public Polygon PolygonParametre(double[] coos)
    {
        Polygon r = new Polygon(coos);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(epaisseurTrait);
        return r;
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
    
    
    public Point2D realToScreenPos(double x, double y)
    {
        return new Point2D(x*pixelsParMetre + origine.getX(), -y*pixelsParMetre + origine.getY());
    }
    
    public Point2D screenToRealPos(double x, double y)
    {
        return new Point2D((x - origine.getX())/pixelsParMetre, -(y - origine.getY())/pixelsParMetre);
    }
    
    EventHandler<MouseEvent> eventClick = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            initPos = new Point2D(e.getX(), e.getY());
            if(e.isMiddleButtonDown())
            {
                prevPos = new Point2D(e.getX(), e.getY());
                return;
            }
            switch(MainProg.mode) {
                case 'p':
                    DessinRectangle(initPos.getX(), initPos.getY(), e.getX(), e.getY(), true);
                    break;
                case 'r':
                    for(Node n : children)
                    {
                        if(n.getClass() == Polygon.class)
                        {
                            if(n.isPressed())
                            {
                                ((Polygon)n).setStroke(Color.BLUE);
                                MainProg.layout.setRight(new ScrollPane(new Inspecteur(pieces.get(n), thisDC, true)));
                                return;
                            }else{
                                ((Polygon)n).setStroke(Color.BLACK);
                            }
                        }
                    }
                    MainProg.layout.setRight(null);
                    break;
                case 's':
                    for(Node n : children)
                    {
                        if(n.getClass() == Polygon.class)
                        {
                            if(n.isPressed())
                            {
                                ((Polygon)n).setStroke(Color.RED);
                                MainProg.layout.setRight(new ScrollPane(new Inspecteur(pieces.get(n), thisDC)));
                                return;
                            }else{
                                ((Polygon)n).setStroke(Color.BLACK);
                            }
                        }
                    }
                    MainProg.layout.setRight(null);
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
                origine = new Point2D(origine.getX() + e.getX() - prevPos.getX(),origine.getY() + e.getY() - prevPos.getY());
                for(Node n : children)
                {
                    n.setTranslateX(n.getTranslateX() + e.getX() - prevPos.getX());
                    n.setTranslateY(n.getTranslateY() + e.getY() - prevPos.getY());
                }
                prevPos = new Point2D(e.getX(), e.getY());
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
                    double x = Double.max(0, Double.min(e.getX(), maxX));
                    double y = Double.max(0, Double.min(e.getY(), maxY));
                    //{xa, ya,    xa, yz,     xz, yz,     xz, ya}
                    double[] coos = new double[]{initPos.getX(),initPos.getY(),initPos.getX(),e.getY(),e.getX(),e.getY(),e.getX(),initPos.getY()};
                    Coin[] coins = new Coin[4];
                    for(int i = 0; i<4; i++)
                    {
                        Point2D pt = screenToRealPos(coos[i*2], coos[i*2+1]);
                        coins[i] = new Coin(pt.getX(), pt.getY());
                    }
                    Piece p = new Piece(coins);
                    pieces.put(children.get(children.size() - 1), p);
                    MainProg.Batimentfinal.getNiveau(niveau).addPiece(p);
                    break;
                default:
                    break;
              }
        }
    };
}
