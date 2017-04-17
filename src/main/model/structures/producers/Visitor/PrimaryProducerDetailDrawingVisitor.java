package model.structures.producers.Visitor;

import javafx.scene.canvas.GraphicsContext;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.structures.producers.primary.ClayPit;
import model.structures.producers.primary.OilRig;
import model.structures.producers.primary.StoneQuarry;
import model.structures.producers.primary.WoodCutter;
import model.structures.producers.primary.mine.Mine;
import view.Camera;
import javafx.scene.image.Image;
import view.assets.AssetManager;

import java.awt.*;

public class PrimaryProducerDetailDrawingVisitor implements PrimaryProducerVisitor {
    private final static double scale = 0.1;
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Sector sector;

    public PrimaryProducerDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
    }

    @Override
    public void visitClayPit(ClayPit clayPit) {
        Image img = assets.getImage("CLAY_PIT");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitOilRig(OilRig oilRig) {
        Image img = assets.getImage("OIL_RIG");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitStoneQuarry(StoneQuarry stoneQuarry) {
        Image img = assets.getImage("QUARRY");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitWoodCutter(WoodCutter woodCutter) {
        Image img = assets.getImage("WOOD_CUTTER");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitMine(Mine mine) {
        Image img = assets.getImage("MINE");
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
