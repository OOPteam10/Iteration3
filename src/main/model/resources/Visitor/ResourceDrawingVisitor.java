package model.resources.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;

public class ResourceDrawingVisitor implements ResourceVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private Sector sector;

    private double scale;
    private int offsetX;
    private int offsetY;

    public ResourceDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera,
                                  Sector sector){
        this.assets = assets;
        this.gc = gc;
        this.camera = camera;
        this.sector = sector;
        this.p = p;
        scale = camera.getResourceScale();
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
        double r = 110*camera.getScale();

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
