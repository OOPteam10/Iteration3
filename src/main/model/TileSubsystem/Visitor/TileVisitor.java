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
public interface TileVisitor {
    void visitLandTile(LandTile tile);
    void visitSeaTile(SeaTile tile);
    void visitRiverTile(RiverTile tile);
    void visitNormalRiver(NormalRiver river);
    void visitSourceRiver(SourceRiver river);
    void visitForkedRiver(ForkedRiver river);
    void visitDesert(Desert terrain);
    void visitMountains(Mountains terrain);
    void visitPasture(Pasture terrain);
    void visitRock(Rock terrain);
    void visitSea(Sea terrain);
    void visitWoods(Woods woods);
}
