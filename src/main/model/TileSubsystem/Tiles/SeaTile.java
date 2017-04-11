package model.TileSubsystem.Tiles;

import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Visitor.TileVisitor;
import model.TileSubsystem.Waterway;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hankerins on 3/26/17.
 */
public class SeaTile extends Tile implements Waterway {
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
    public void addToSurfaceMap(Location l, LandMap lm, WaterwayMap wm){
        wm.add(l, this);
    }
    public ArrayList<HexSide> getWaterwaySides(){
        return new ArrayList<HexSide>(Arrays.asList(getSides()));
    }
    public boolean contains(HexSide hs){
        return true;
    }

    //testing only
    public String toString(){
        return "SeaTile: ";
    }
}
