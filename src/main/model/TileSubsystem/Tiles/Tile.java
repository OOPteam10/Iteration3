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
    private CardinalDirection[] halfEdges = CardinalDirection.values();
    private Terrain terrain;
    private ArrayList<Sector> sectors = new ArrayList<Sector>();

    protected abstract void configureSectors();
    public abstract void accept(TileVisitor v);

    public void addSector(Sector sector) {
        sectors.add(sector);
    }

    public ArrayList<Sector> getSectors() {
        return sectors;
    }

    public Terrain getTerrain(){
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
