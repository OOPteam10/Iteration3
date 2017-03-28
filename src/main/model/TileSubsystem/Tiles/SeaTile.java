package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class SeaTile extends Tile {
    public SeaTile(Sea sea){
        setTerrain(sea);
        configureSectors();
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitSeaTile(this);
    }

    @Override
    protected void configureSectors() {
        Sector sector = new Sector(CardinalDirection.NNE, CardinalDirection.NNW);
        addSector(sector);
    }
}
