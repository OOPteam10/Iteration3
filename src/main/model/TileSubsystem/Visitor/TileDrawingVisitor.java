package model.TileSubsystem.Visitor;

import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;

/**
 * Created by allisonaguirre on 3/26/17.
 */
public class TileDrawingVisitor implements TileVisitor {

    public TileDrawingVisitor() {

    }

    @Override
    public void visitLandTile(LandTile tile) {

    }

    @Override
    public void visitSeaTile(SeaTile tile) {

    }

    @Override
    public void visitRiverTile(RiverTile tile) {

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
