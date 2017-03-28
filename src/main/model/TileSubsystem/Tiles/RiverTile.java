package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class RiverTile extends LandTile {

    private River river;

    public RiverTile(Terrain terrain, River river){
        super(terrain);
        this.river = river;
        configureSectors();
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitRiverTile(this);
    }

    @Override
    protected void configureSectors() {
        if (river != null) {
            ArrayList<HexSide> riverEdges = river.getEdges();

            for (int i = 0; i < riverEdges.size(); i++) {
                if (i < riverEdges.size()-1) {
                    // if there still are edges to connect
                    Sector sector = new Sector(riverEdges.get(i).getSecondHalf(), riverEdges.get(i+1).getFirstHalf());
                    addSector(sector);
                } else {
                    Sector sector = new Sector(riverEdges.get(i).getSecondHalf(), riverEdges.get(0).getFirstHalf());
                    addSector(sector);
                }
            }
        }
    }

    public River getRiver(){
        return river;
    }
}
