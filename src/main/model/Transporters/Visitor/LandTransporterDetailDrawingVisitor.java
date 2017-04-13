package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.Truck;
import model.Transporters.Wagon;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

/**
 * Created by Karth on 4/12/2017.
 */
public class LandTransporterDetailDrawingVisitor implements LandTransporterVisitor {
    private final static double scale = 0.2;

    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Sector sector;
    public LandTransporterDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
    }

    @Override
    public void visitDonkey(Donkey donkey){
        Image img = assets.getImage("DONKEY");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        //Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get());
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,assets.getImage("DONKEY").getWidth()*scale,
                assets.getImage("DONKEY").getHeight()*scale);
    }

    @Override
    public void visitWagon(Wagon wagon){
        Image img = assets.getImage("WAGON");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        //Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get());
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,assets.getImage("WAGON").getWidth()*scale,
                assets.getImage("WAGON").getHeight()*scale);
    }

    @Override
    public void visitTruck(Truck truck){
        Image img = assets.getImage("TRUCK");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2), img);
        //Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get());
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,assets.getImage("TRUCK").getWidth()*scale,
                assets.getImage("TRUCK").getHeight()*scale);
    }

    private int CardinalDirectionToDegree(CardinalDirection c){
        int degree;
        degree = -1* c.getDegree() + 90;

        return degree;
    }

    private Point findDrawingPoint(CardinalDirection cardinalDirection, Image img){
        Point sectorDrawingLocation = new Point();
        double x = 1383*camera.getBackgroundScaleX();
        double y = 689*camera.getBackgroundScaleY();
        double r = 100*Math.sqrt(Math.pow(camera.getBackgroundScaleX(),2)+Math.pow(camera.getBackgroundScaleY(),2));

        x = x+(int) (r* Math.cos(Math.toRadians((CardinalDirectionToDegree(cardinalDirection)))));
        y= y - 1*((int) (r* Math.sin(Math.toRadians((CardinalDirectionToDegree(cardinalDirection))))));

        sectorDrawingLocation.x = (int) x - (int)(img.getWidth()*scale/2);
        sectorDrawingLocation.y = (int) y - (int)(img.getHeight()*scale/2);

//        System.out.println(sector.getHalfEdges().get(sector.getHalfEdges().size()/2));
//        System.out.println(sectorDrawingLocation.x);
//        System.out.println(sectorDrawingLocation.y);

        return sectorDrawingLocation;
    }
}
