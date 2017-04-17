package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.Steamship;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

public class SeaTransporterShoreDetailDrawingVisitor implements  SeaTransporterVisitor{

    private final static double scale = 0.1;
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Sector sector;

    public SeaTransporterShoreDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
    }

    @Override
    public void visitRaft(Raft raft) {
        javafx.scene.image.Image img = assets.getImage("RAFT");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitRowboat(Rowboat rowboat) {
        Image img = assets.getImage("ROWBOAT");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitSteamship(Steamship steamship) {
        Image img = assets.getImage("STEAMSHIP");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);

    }


    private Point findDrawingPoint(CardinalDirection cardinalDirection, javafx.scene.image.Image img){
        Point sectorDrawingLocation = new Point();
        double x = 1383*camera.getBackgroundScaleX();
        double y = 689*camera.getBackgroundScaleY();
        double r = 40*Math.sqrt(Math.pow(camera.getBackgroundScaleX(),2)+Math.pow(camera.getBackgroundScaleY(),2));

        x = x+(int) (r* Math.cos(Math.toRadians((CardinalDirectionToDegree(cardinalDirection)))));
        y= y - 1*((int) (r* Math.sin(Math.toRadians((CardinalDirectionToDegree(cardinalDirection))))));

        sectorDrawingLocation.x = (int) x - (int)(img.getWidth()*scale/2);
        sectorDrawingLocation.y = (int) y - (int)(img.getHeight()*scale/2);

//        System.out.println(sector.getHalfEdges().get(sector.getHalfEdges().size()/2));
//        System.out.println(sectorDrawingLocation.x);
//        System.out.println(sectorDrawingLocation.y);

        return sectorDrawingLocation;
    }

    private int CardinalDirectionToDegree(CardinalDirection c){
        int degree;
        degree = -1* c.getDegree() + 90;

        return degree;
    }
}
