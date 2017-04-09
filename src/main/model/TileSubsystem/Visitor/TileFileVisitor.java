package model.TileSubsystem.Visitor;

import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import utilities.FileManager.TileFileInfo;

/**
 * Created by doug0_000 on 3/27/2017.
 */

public class TileFileVisitor implements TileVisitor {

    private TileFileInfo tileInfo;

    public TileFileVisitor() {
        this.tileInfo = new TileFileInfo();
    }

    @Override
    public void visitLandTile(LandTile tile) {
        tile.getTerrain().accept(this);
    }

    @Override
    public void visitSeaTile(SeaTile tile) {
        tile.getTerrain().accept(this);
    }

    @Override
    public void visitRiverTile(RiverTile tile) {
        tile.getTerrain().accept(this);
        tile.getRiver().accept(this);
    }

    @Override
    public void visitNormalRiver(NormalRiver river) {
        tileInfo.setRiverEdges(river.getEdges());
    }

    @Override
    public void visitSourceRiver(SourceRiver river) {
        tileInfo.setRiverEdges(river.getEdges());
    }

    @Override
    public void visitForkedRiver(ForkedRiver river) {
        tileInfo.setRiverEdges(river.getEdges());

    }

    @Override
    public void visitDesert(Desert terrain) {
        tileInfo.setTerrain("desert");
    }

    @Override
    public void visitMountains(Mountains terrain) {
        tileInfo.setTerrain("mountains");
    }

    @Override
    public void visitPasture(Pasture terrain) {
        tileInfo.setTerrain("pasture");
    }

    @Override
    public void visitRock(Rock terrain) {
        tileInfo.setTerrain("rock");
    }

    @Override
    public void visitSea(Sea terrain) {
        tileInfo.setTerrain("sea");
    }

    @Override
    public void visitWoods(Woods woods) {
        tileInfo.setTerrain("woods");
    }

    public TileFileInfo getTileInfo() {return tileInfo;}

    public void refresh() {
        tileInfo = new TileFileInfo();
    }
}
