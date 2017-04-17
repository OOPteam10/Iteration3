package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.SeaTransporter;
import model.Transporters.Steamship;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

public class SeaTransporterShoreDrawingVisitor implements SeaTransporterVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sector;

    private double scale;
    private int offsetX;
    private int offsetY;

    public SeaTransporterShoreDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera,
                                  Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
        this.p = p;
        scale = camera.getTransporterScale();
    }


    @Override
    public void visitRaft(Raft raft) {
        Image img = assets.getImage("RAFT");
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

    private int getOffsetX(){
        offsetX = (int)(camera.getTileWidth()*camera.getScale()/2);
        return offsetX;
    }

    private int getOffsetY(){
        offsetY = (int)(camera.getTileHeight()*camera.getScale()/2);
        return offsetY;
    }

    private Point findDrawingPoint(CardinalDirection cardinalDirection, javafx.scene.image.Image img){
        Point sectorDrawingLocation = new Point();
        double x = (camera.offset(p).x+getOffsetX());
        double y = camera.offset(p).y+getOffsetY();
        double r = 50*camera.getScale();

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
