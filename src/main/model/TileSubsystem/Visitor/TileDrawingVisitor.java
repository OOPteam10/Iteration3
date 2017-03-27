package model.TileSubsystem.Visitor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.MapSubsystem.Location;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by allisonaguirre on 3/26/17.
 */
public class TileDrawingVisitor implements TileVisitor {

    private AssetManager assets;
    private GraphicsContext gc;
    Point p;
    // current constructed tile

    public TileDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p) {
        this.assets = assets;
        this.gc = gc;
        this.p = p;
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
        // tile.getTerrain.accept(this)
        // tile.getRiver.accept(this)
    }

    @Override
    public void visitNormalRiver(NormalRiver river) {

    }

    @Override
    public void visitSourceRiver(SourceRiver river) {

    }

    @Override
    public void visitForkedRiver(ForkedRiver river) {

    }

    @Override
    public void visitDesert(Desert terrain) {

    }

    @Override
    public void visitMountains(Mountains terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("MOUNTAIN_TILE");
        gc.drawImage(img, p.x, p.y);
    }

    @Override
    public void visitPasture(Pasture terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("GRASS_TILE");
        gc.drawImage(img, p.x, p.y);
    }

    @Override
    public void visitRock(Rock terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("ROCK_TILE");
        gc.drawImage(img, p.x, p.y);
    }

    @Override
    public void visitSea(Sea terrain) {
        // do something with this, draw over current constructed tile
        Image img = assets.getImage("SEA_TILE");
        gc.drawImage(img, p.x, p.y);
    }

    @Override
    public void visitWoods(Woods woods) {

    }
}
