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

public class PrimaryProducerDrawingVisitor implements  PrimaryProducerVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sector;

    private double scale;
    private int offsetX;
    private int offsetY;


    public PrimaryProducerDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
        this.p = p;
        scale = camera.getProducerScale();
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
        double r = 40*camera.getScale();

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
