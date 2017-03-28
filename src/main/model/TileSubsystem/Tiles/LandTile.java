package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class LandTile extends Tile {
    public LandTile(Terrain terrain){
        setTerrain(terrain);
        configureSectors();
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitLandTile(this);
    }

    @Override
    protected void configureSectors() {
        Sector sector = new Sector(CardinalDirection.NNE, CardinalDirection.NNW);
        addSector(sector);
    }
}
