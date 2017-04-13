package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TileSubsystem.Sector;
import model.Transporters.Truck;
import model.Transporters.Wagon;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/12/2017.
 */
public class RoadTransporterDrawingVisitor implements  RoadTransporterVisitor{
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sectorLocation;

    private double scale;
    private int offsetX;
    private int offsetY;


    public RoadTransporterDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sectorLocation = sectorLocation;
        this.p = p;
        scale = camera.getScale()*0.5;
        offsetX = (int)(43* camera.getScale()/0.3);
        offsetY = (int)(15*camera.getScale()/0.3);
    }

    @Override
    public void visitWagon(Wagon wagon){
        Image img = assets.getImage("WAGON");
        gc.drawImage(img, camera.offset(p).x + offsetX, camera.offset(p).y+offsetY,
                assets.getImage("WAGON").getWidth()*scale,
                assets.getImage("WAGON").getHeight()*scale);
    }

    @Override
    public void visitTruck(Truck truck){
        Image img = assets.getImage("TRUCK");
        gc.drawImage(img, camera.offset(p).x + offsetX, camera.offset(p).y+offsetY,
                assets.getImage("TRUCK").getWidth()*scale,
                assets.getImage("TRUCK").getHeight()*scale);
    }
}
