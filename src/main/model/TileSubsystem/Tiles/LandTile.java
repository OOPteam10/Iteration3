package model.TileSubsystem.Tiles;

import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class LandTile extends Tile {
    public LandTile(Terrain terrain){
        setTerrain(terrain);
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitLandTile(this);
    }
}
