package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class RiverTile extends LandTile {

    River river;

    public RiverTile(Terrain terrain, River river){
        super(terrain);
        this.river = river;
        setSectors();
        // how to set up sectors for river tile?
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitRiverTile(this);
    }

    @Override
    public void setSectors() {
        if (river != null) {
            ArrayList<CardinalDirection> riverEdges = river.getEdges();
            for (int i = 0; i < riverEdges.size(); i++) {
                if (i < riverEdges.size()-1) {
                    // if there still are edges to connect
                    Sector sector = new Sector(riverEdges.get(i), riverEdges.get(i+1).previous());
                    addSector(sector);
                } else {
                    Sector sector = new Sector(riverEdges.get(i), riverEdges.get(0).previous());
                }
            }
        }
    }
}
