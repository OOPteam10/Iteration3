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
        setSectors();
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitLandTile(this);
    }

    @Override
    public void setSectors() {
        Sector sector = new Sector(CardinalDirection.NNE, CardinalDirection.NNW);
        addSector(sector);
    }
}
