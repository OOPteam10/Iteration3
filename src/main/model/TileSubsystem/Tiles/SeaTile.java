package model.TileSubsystem.Tiles;

import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class SeaTile extends Tile {
    public SeaTile(Sea sea){
        this.terrain = sea;
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitSeaTile(this);
    }
}
