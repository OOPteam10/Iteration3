package model.resources.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/15/2017.
 */
public class ResourceDetailDrawingVisitor implements ResourceVisitor{

    private final static double scale = 0.1;
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Sector sector;

    public ResourceDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Camera camera, Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
    }

    @Override
    public void visitBoard() {
        Image img = assets.getImage("BOARD");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitClay() {
        Image img = assets.getImage("CLAY");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitCoin() {
        Image img = assets.getImage("COIN");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitFuel() {
        Image img = assets.getImage("FUEL");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitGold() {
        Image img = assets.getImage("GOLD");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitIron() {
        Image img = assets.getImage("IRON");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitPaper() {
        Image img = assets.getImage("PAPER");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitStock() {
        Image img = assets.getImage("STOCK");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitStone() {
        Image img = assets.getImage("STONE");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    @Override
    public void visitTrunk() {
        Image img = assets.getImage("TRUNK");
        Point drawingPoint = findDrawingPoint(sector.getHalfEdges().get(sector.getHalfEdges().size()/2),img);
        gc.drawImage(img, drawingPoint.x, drawingPoint.y,
                img.getWidth()*scale, img.getHeight()*scale);
    }

    private Point findDrawingPoint(CardinalDirection cardinalDirection, javafx.scene.image.Image img){
        Point sectorDrawingLocation = new Point();
        double x = 1383*camera.getBackgroundScaleX();
        double y = 689*camera.getBackgroundScaleY();
        double r = 70*Math.sqrt(Math.pow(camera.getBackgroundScaleX(),2)+Math.pow(camera.getBackgroundScaleY(),2));

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
