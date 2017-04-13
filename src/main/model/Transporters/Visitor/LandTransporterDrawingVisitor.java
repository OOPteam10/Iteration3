package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.*;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

public class LandTransporterDrawingVisitor implements  LandTransporterVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sectorLocation;

    private double scale;
    private int offsetX;
    private int offsetY;

    public LandTransporterDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sectorLocation = sectorLocation;
        this.p = p;
        scale = camera.getScale()*0.5;
        
       
    }

    @Override
    public void visitDonkey(Donkey donkey){
        Image img = assets.getImage("DONKEY");
        gc.drawImage(img, camera.offset(p).x+getOffsetX(img)-assets.getImage("DONKEY").getWidth()*scale,
                camera.offset(p).y+getOffsetY(img),
                assets.getImage("DONKEY").getWidth()*scale,
                assets.getImage("DONKEY").getHeight()*scale);
    }


    @Override
    public void visitWagon(Wagon wagon){
        Image img = assets.getImage("WAGON");
        gc.drawImage(img, camera.offset(p).x + getOffsetX(img), camera.offset(p).y+getOffsetY(img),
                assets.getImage("WAGON").getWidth()*scale,
                assets.getImage("WAGON").getHeight()*scale);
    }

    @Override
    public void visitTruck(Truck truck){
        Image img = assets.getImage("TRUCK");
        gc.drawImage(img, camera.offset(p).x + getOffsetX(img)+assets.getImage("DONKEY").getWidth()*scale,
                camera.offset(p).y+getOffsetY(img),
                assets.getImage("TRUCK").getWidth()*scale,
                assets.getImage("TRUCK").getHeight()*scale);
    }

    private int getOffsetX(Image img){
        offsetX = (int)(400*camera.getScale()/2-img.getWidth()*scale/2);
        return offsetX;
    }
    
    private int getOffsetY(Image img){
        offsetY = (int)(200*camera.getScale()/2-img.getHeight()*scale/2);
        return offsetY;
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
