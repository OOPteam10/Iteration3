package model.Transporters.Visitor;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.SeaTransporter;
import model.Transporters.Steamship;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

public class SeaTransporterDrawingVisitor implements SeaTransporterVisitor{
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;

    private double scale;
    private int offsetX;
    private int offsetY;

    public SeaTransporterDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.p = p;
        scale = camera.getTransporterScale();
    }

    @Override
    public void visitRaft(Raft raft){
        Image img = assets.getImage("RAFT");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x,drawingPoint.y,
                img.getWidth()*scale,
                img.getHeight()*scale);
    }

    @Override
    public void visitRowboat(Rowboat rowboat){
        Image img = assets.getImage("ROWBOAT");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x,drawingPoint.y,
                img.getWidth()*scale,
                img.getHeight()*scale);
    }

    @Override
    public void visitSteamship(Steamship steamship){
        Image img = assets.getImage("STEAMSHIP");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x,drawingPoint.y,
                img.getWidth()*scale,
                img.getHeight()*scale);
    }



    private int getOffsetX(){
        offsetX = (int)(camera.getTileWidth()*camera.getScale()/2);
        return offsetX;
    }

    private int getOffsetY(){
        offsetY = (int)(camera.getTileHeight()*camera.getScale()/2);
        return offsetY;
    }


    private Point findDrawingPoint(Image img){
        Point sectorDrawingLocation = new Point();

        double x = (camera.offset(p).x+getOffsetX());
        double y = camera.offset(p).y+getOffsetY();
        double r = 140*camera.getScale();

        sectorDrawingLocation.x = (int) x - (int)(img.getWidth()*scale/2);
        sectorDrawingLocation.y = (int) y - (int)(img.getHeight()*scale/2);

//        System.out.println(sector.getHalfEdges().get(sector.getHalfEdges().size()/2));
//        System.out.println(sectorDrawingLocation.x);
//        System.out.println(sectorDrawingLocation.y);

        return sectorDrawingLocation;
    }

}
