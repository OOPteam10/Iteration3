package model.TileSubsystem.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import view.Camera;
import view.assets.AssetManager;

import java.awt.*;


/**
 * Created by allisonaguirre on 3/26/17.
 */
public class TileDrawingVisitor implements TileVisitor {

    private final static int ROTATION_ANGLE = 60;

    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    // current constructed tile


    public TileDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera) {
        this.assets = assets;
        this.gc = gc;
        this.p = p;

        this.camera = camera;
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
            drawRotatedImage(img, river.getHexagonSide() * ROTATION_ANGLE, camera.offset(p).x, camera.offset( p).y);
        }
        catch(NullPointerException e){
            System.out.println("Wrong angle, malfunctioning normal river. Angle = "+normalRiverAngle);
        }
    }

    @Override
    public void visitSourceRiver(SourceRiver river) {
        Image img = assets.getImage("SOURCE_RIVER");
        drawRotatedImage(img, river.getHexagonSide()*ROTATION_ANGLE, camera.offset( p).x, camera.offset( p).y);
    }

    @Override
    public void visitForkedRiver(ForkedRiver river) {
        Image img = assets.getImage("FORKED_RIVER");
        drawRotatedImage(img, river.getHexagonSide()*ROTATION_ANGLE, camera.offset( p).x, camera.offset(p).y);
    }

    @Override
    public void visitDesert(Desert terrain) {
        Image img = assets.getImage("DESERT_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }

    @Override
    public void visitMountains(Mountains terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("MOUNTAIN_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }

    @Override
    public void visitPasture(Pasture terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("GRASS_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }

    @Override
    public void visitRock(Rock terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("ROCK_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }

    @Override
    public void visitSea(Sea terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("SEA_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }

    @Override
    public void visitWoods(Woods woods) {
        Image img = assets.getImage("WOOD_TILE");
        gc.drawImage(img, camera.offset( p).x, camera.offset( p).y,camera.getScale() * img.getWidth(),
                camera.getScale() * img.getHeight());
    }


    //TODO integrate these function into a ImagePlacementTranslator class

    private void drawRotatedImage(Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        camera.rotate(gc, angle, tlpx + image.getWidth()*camera.getScale() / 2, tlpy + image.getHeight()*camera.getScale() / 2);
        gc.drawImage(image, tlpx, tlpy, camera.getScale() * image.getWidth(),
                camera.getScale() * image.getHeight());
        gc.restore(); // back to original state (before rotation)
    }
}
