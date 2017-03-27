package model.TileSubsystem.Visitor;

import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import view.assets.AssetManager;

/**
 * Created by allisonaguirre on 3/26/17.
 */
public class TileDrawingVisitor implements TileVisitor {

    private AssetManager assets;
    // current constructed tile

    public TileDrawingVisitor(AssetManager assets) {
        this.assets = assets;
    }

    @Override
    public void visitLandTile(LandTile tile) {
        // start basic tile graphic (don't know terrain yet)
        // tile.getTerrain.accept(this)
    }

    @Override
    public void visitSeaTile(SeaTile tile) {
        // start basic tile graphic (don't know terrain truly yet)
        // tile.getTerrain.accept(this)
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
        assets.getImage("MOUNTAIN_TILE");
    }

    @Override
    public void visitPasture(Pasture terrain) {
        // do something with this, draw over current constructed tile
        assets.getImage("GRASS_TILE");
    }

    @Override
    public void visitRock(Rock terrain) {
        // do something with this, draw over current constructed tile
        assets.getImage("ROCK_TILE");
    }

    @Override
    public void visitSea(Sea terrain) {
        // do something with this, draw over current constructed tile
        assets.getImage("SEA_TILE");
    }

    @Override
    public void visitWoods(Woods woods) {

    }
}
