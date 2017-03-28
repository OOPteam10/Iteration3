package model.TileSubsystem.Visitor;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import model.MapSubsystem.Location;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import view.Tool.ImageLocationTranslator;
import view.assets.AssetManager;

import java.awt.*;


/**
 * Created by allisonaguirre on 3/26/17.
 */
public class TileDrawingVisitor implements TileVisitor {

    private final static int ROTATION_ANGLE = 60;

    private AssetManager assets;
    private GraphicsContext gc;
    private ImageLocationTranslator imageTranslator;
    Point p;
    // current constructed tile


    public TileDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p) {
        this.assets = assets;
        this.gc = gc;
        this.p = p;

        imageTranslator = new ImageLocationTranslator(gc, p);
    }

    @Override
    public void visitLandTile(LandTile tile) {
        // start basic tile graphic (don't know terrain yet)
        tile.getTerrain().accept(this);
    }

    @Override
    public void visitSeaTile(SeaTile tile) {
        // start basic tile graphic (don't know terrain truly yet)
        tile.getTerrain().accept(this);

    }

    @Override
    public void visitRiverTile(RiverTile tile) {
        // start basic tile graphic (don't know terrain yet)
        tile.getTerrain().accept(this);
        tile.getRiver().accept(this);
    }

    @Override
    public void visitNormalRiver(NormalRiver river) {
        int normalRiverAngle = river.calculateAngle();
        Image img;
        switch(normalRiverAngle){
            case 60:
                img = assets.getImage("NORMAL_RIVER_60");
                break;
            case 120:
                img = assets.getImage("NORMAL_RIVER_120");
                break;
            case 180:
                img = assets.getImage("NORMAL_RIVER_180");
                break;
            default:
                img = null;
                break;
        }
        try {
            drawRotatedImage(img, river.getHexagonSide() * ROTATION_ANGLE, imageTranslator.offset().x, imageTranslator.offset().y);
        }
        catch(NullPointerException e){
            System.out.println("Wrong angle, malfunctioning normal river. Angle = "+normalRiverAngle);
        }
    }

    @Override
    public void visitSourceRiver(SourceRiver river) {
        Image img = assets.getImage("SOURCE_RIVER");
        drawRotatedImage(img, river.getHexagonSide()*ROTATION_ANGLE, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitForkedRiver(ForkedRiver river) {
        Image img = assets.getImage("FORKED_RIVER");
        drawRotatedImage(img, river.getHexagonSide()*ROTATION_ANGLE, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitDesert(Desert terrain) {

    }

    @Override
    public void visitMountains(Mountains terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("MOUNTAIN_TILE");
        gc.drawImage(img, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitPasture(Pasture terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("GRASS_TILE");
        gc.drawImage(img, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitRock(Rock terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("ROCK_TILE");
        gc.drawImage(img, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitSea(Sea terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("SEA_TILE");
        gc.drawImage(img, imageTranslator.offset().x, imageTranslator.offset().y);
    }

    @Override
    public void visitWoods(Woods woods) {

    }


    //TODO integrate these function into a ImagePlacementTranslator class

    private void drawRotatedImage(Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        imageTranslator.rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }

//    private void rotate(GraphicsContext gc, double angle, double px, double py) {
//        Rotate r = new Rotate(angle, px, py);
//        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
//    }
//
//    public Point offset(Point p) {
//        Point offsetTile = new Point();
//        Point offset = new Point(1024/2-115,768/2-100);
//
//        offsetTile.x = getPixelLocation(p).x + offset.x;
//        offsetTile.y = getPixelLocation(p).y + offset.y;
//        return offsetTile;
//    }
//
//    public Point getPixelLocation(Point tile) {
//        Point pixelLocation = new Point();
//        int HEX_W = 115;
//        int HEX_H = 100;
//        pixelLocation.x = (int)(0.75f * HEX_W * tile.x);
//        pixelLocation.y = (int)(HEX_H * (tile.x * 0.5f + tile.y));
//        return pixelLocation;
//    }
}
