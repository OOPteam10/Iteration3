package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;
import model.Transporters.Truck;
import model.Transporters.Wagon;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

public class LandTransporterDrawingVisitor implements  LandTransporterVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sector;

    private double scale;
    private int offsetX;
    private int offsetY;

    public LandTransporterDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
        this.p = p;
        scale = camera.getTransporterScale();
    }

    @Override
    public void visitDonkey(Donkey donkey){
        Image img = assets.getImage("DONKEY");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        gc.drawImage(img, drawingPoint.x,drawingPoint.y,
                assets.getImage("DONKEY").getWidth()*scale,
                assets.getImage("DONKEY").getHeight()*scale);
    }


    @Override
    public void visitWagon(Wagon wagon){
        Image img = assets.getImage("WAGON");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                assets.getImage("WAGON").getWidth()*scale,
                assets.getImage("WAGON").getHeight()*scale);
    }

    @Override
    public void visitTruck(Truck truck){
        Image img = assets.getImage("TRUCK");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        gc.drawImage(img, drawingPoint.x,
                drawingPoint.y,
                assets.getImage("TRUCK").getWidth()*scale,
                assets.getImage("TRUCK").getHeight()*scale);
    }

    private int getOffsetX(){
        offsetX = (int)(camera.getTileWidth()*camera.getScale()/2);
        return offsetX;
    }
    
    private int getOffsetY(){
        offsetY = (int)(camera.getTileHeight()*camera.getScale()/2);
        return offsetY;
    }


    private Point findDrawingPoint(CardinalDirection cardinalDirection, Image img){
        Point sectorDrawingLocation = new Point();
        double x = (camera.offset(p).x+getOffsetX());
        double y = camera.offset(p).y+getOffsetY();
        double r = 140*camera.getScale();

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
//
//    private Point findDrawingPoint(CardinalDirection cardinalDirection){
//        Point sectorDrawingLocation = new Point();
//        double x = 1386*camera.getBackgroundScaleX();
//        double y = 685*camera.getBackgroundScaleY();
//        double r = 125*Math.sqrt(Math.pow(camera.getBackgroundScaleX(),2)+Math.pow(camera.getBackgroundScaleY(),2));
//
//        x = x+(int) (r* Math.cos(Math.toRadians((cardinalDirection.getDegree()))));
//        y= y - 1*((int) (r* Math.sin(Math.toRadians((cardinalDirection.getDegree())))));
//
//        sectorDrawingLocation.x = (int) x;
//        sectorDrawingLocation.y = (int) y;
//
//        return sectorDrawingLocation;
//    }
}
