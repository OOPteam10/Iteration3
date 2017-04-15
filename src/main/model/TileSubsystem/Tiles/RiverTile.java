package model.TileSubsystem.Tiles;

import model.Managers.SeaTransporterManager;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class RiverTile extends LandTile implements Waterway {

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

    public void addToSurfaceMap(Location l, LandMap lm, WaterwayMap wm){
        lm.add(l, this);
        wm.add(l, this);
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

    public ArrayList<SeaTransporter> getSeaTransporters(SeaTransporterManager stm){
        return stm.getContentsOfArea(this);
    }

    public River getRiver(){
        return river;
    }

    public ArrayList<HexSide> getWaterwaySides(){
        return river.getEdges();
    }
    public boolean contains(HexSide hs){
        return river.contains(hs);
    }

    //testing only
    public String toString(){
        return ("RiverTile: " + getTerrain().toString() + " " + river.toString());
    }
}
