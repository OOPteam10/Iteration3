package model.TileSubsystem.Visitor;

import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;

/**
 * Created by hankerins on 3/28/17.
 */
public class RiverTileValidationVisitor implements TileVisitor {
    private boolean isValid = true;
    private RiverTile source;
    private HexSide adjacency;


    public RiverTileValidationVisitor(RiverTile source, HexSide adjacency){
        this.source = source;
        this.adjacency = adjacency;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public void visitLandTile(LandTile tile) {
        isValid = River.validateRiverToLandConnection( source.getRiver(),  adjacency);
    }

    @Override
    public void visitSeaTile(SeaTile tile) {

    }

    @Override
    public void visitRiverTile(RiverTile tile) {
        isValid = River.validateRiverConnection(source.getRiver(), tile.getRiver(),  adjacency);
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

    }

    @Override
    public void visitPasture(Pasture terrain) {

    }

    @Override
    public void visitRock(Rock terrain) {

    }

    @Override
    public void visitSea(Sea terrain) {

    }

    @Override
    public void visitWoods(Woods woods) {

    }
}
