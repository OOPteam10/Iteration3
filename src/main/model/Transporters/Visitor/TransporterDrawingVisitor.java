package model.Transporters.Visitor;

import javafx.scene.canvas.GraphicsContext;
import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

public class TransporterDrawingVisitor implements  TransporterVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Location location;
    private Point p;
    private Sector sectorLocation;
    public TransporterDrawingVisitor(AssetManager assets, GraphicsContext gc, Location location, Camera camera,
                                     Sector sectorLocation ){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.location = location;
        this.sectorLocation = sectorLocation;
        p = new Point();
        p.x = location.getX();
        p.y = location.getY();
    }

    @Override
    public void visitLandTransporter(LandTransporter landTransporter){

    }

    @Override
    public void visitDonkey(Donkey donkey){
        Image img = assets.getImage("DONKEY");
        gc.drawImage(img, camera.offset(p).x + 10, camera.offset(p).y + 10,
                assets.getImage("DONKEY").getWidth()*camera.getScale(),
                assets.getImage("DONKEY").getHeight()*camera.getScale());
        drawOnTileDetail(img);
    }

    private void drawOnTileDetail(Image image){
        Point drawLocation = findDrawingPoint(sectorLocation.getHalfEdges().get(0));
        gc.drawImage(image, drawLocation.x, drawLocation.y);
    }

    private Point findDrawingPoint(CardinalDirection cardinalDirection){
        Point sectorDrawingLocation = new Point();
        double x = 1386*camera.getBackgroundScaleX();
        double y = 685*camera.getBackgroundScaleY();
        double r = 125*Math.sqrt(Math.pow(camera.getBackgroundScaleX(),2)+Math.pow(camera.getBackgroundScaleY(),2));

        x = x+(int) (r* Math.cos(Math.toRadians((cardinalDirection.getDegree()))));
        y= y - 1*((int) (r* Math.sin(Math.toRadians((cardinalDirection.getDegree())))));

        sectorDrawingLocation.x = (int) x;
        sectorDrawingLocation.y = (int) y;

        return sectorDrawingLocation;
    }
}
