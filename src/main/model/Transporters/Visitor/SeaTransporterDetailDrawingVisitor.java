package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.Steamship;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

public class SeaTransporterDetailDrawingVisitor implements SeaTransporterVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;

    private double scale = 0.2;
    private int offsetX;
    private int offsetY;

    public SeaTransporterDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Camera camera){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
    }

    @Override
    public void visitRaft(Raft raft) {
        Image img = assets.getImage("RAFT");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,img.getWidth()*scale,
                img.getHeight()*scale);
    }

    @Override
    public void visitRowboat(Rowboat rowboat) {
        Image img = assets.getImage("ROWBOAT");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,img.getWidth()*scale,
                img.getHeight()*scale);
    }

    @Override
    public void visitSteamship(Steamship steamship) {
        Image img = assets.getImage("STEAMSHIP");
        Point drawingPoint = findDrawingPoint(img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,img.getWidth()*scale,
                img.getHeight()*scale);

    }

    private Point findDrawingPoint(Image img){
        Point sectorDrawingLocation = new Point();
        double x = 1383*camera.getBackgroundScaleX();
        double y = 689*camera.getBackgroundScaleY();

        sectorDrawingLocation.x = (int) x - (int)(img.getHeight()*scale/2);
        sectorDrawingLocation.y = (int) y - (int)(img.getHeight()*scale/2);

//        System.out.println(sector.getHalfEdges().get(sector.getHalfEdges().size()/2));
//        System.out.println(sectorDrawingLocation.x);
//        System.out.println(sectorDrawingLocation.y);

        return sectorDrawingLocation;
    }
}
