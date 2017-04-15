package model.TileSubsystem.Tiles;

import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public abstract class Tile {
    private CardinalDirection[] halfEdges = CardinalDirection.values();
    private Terrain terrain;
    private ArrayList<Sector> sectors = new ArrayList<Sector>();
    private HexSide[] sides = HexSide.values();

    protected abstract void configureSectors();

    public abstract void addToSurfaceMap(Location l, LandMap lm, WaterwayMap wm);

    protected void addSector(Sector sector) {
        sectors.add(sector);
    }

    public Sector getSectorAtCardinalDirection(CardinalDirection cd){
        for(Sector s:sectors){
            if(s.getHalfEdges().contains(cd))
                return s;
        }
        return null;
    }

    public ArrayList<Sector> getSectorsAtHexSide(HexSide hs){
        ArrayList<Sector> sectorsAtHexSide = new ArrayList<Sector>();
        for(Sector s:sectors){
            if(s.contains(hs.getFirstHalf()) || s.contains(hs.getSecondHalf())) {
                sectorsAtHexSide.add(s);
            }
        }
        return sectorsAtHexSide;
    }


    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public abstract void accept(TileVisitor v);
    public Terrain getTerrain(){return terrain;}
    public CardinalDirection[] getHalfEdges() {return halfEdges;}
    public ArrayList<Sector> getSectors() {return sectors;}
    public HexSide[] getSides() {return sides;}

}
