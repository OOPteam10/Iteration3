package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

import javax.smartcardio.Card;
import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public abstract class Tile {
    protected CardinalDirection[] halfEdges = CardinalDirection.values();
    protected Terrain terrain;
    protected ArrayList<Sector> sectors;
    public abstract void accept(TileVisitor v);
    public Terrain getTerrain(){return terrain;}
}
