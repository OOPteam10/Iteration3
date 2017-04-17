package model.MapSubsystem;

import model.Managers.SectorAdjacency;
import model.Managers.SectorAdjacencyManager;
import model.Managers.SectorToWaterwayManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Waterway;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/10/17.
 */
public class LandMap extends SurfaceMap<LandTile> {

    public SectorToWaterwayManager generateSectorToWaterwayManager(WaterwayMap waterwayMap){
        SectorToWaterwayManager stwm = new SectorToWaterwayManager();
        for(Location loc: getSurfaces().keySet()){
            addLocationToSectorToWaterwayManager(loc, stwm, waterwayMap);
        }
        return stwm;
    }

    private void addLocationToSectorToWaterwayManager(Location loc, SectorToWaterwayManager stwm, WaterwayMap waterwayMap){
        for(Sector s: getSurfaces().get(loc).getSectors()) {
            stwm.add(s, createWaterwayList(loc, s, waterwayMap));
        }
    }

    private ArrayList<Waterway> createWaterwayList(Location loc, Sector s, WaterwayMap waterwayMap){
        ArrayList<Waterway> waterways = new ArrayList<Waterway>();
        if(waterwayMap.getTile(loc) != null){
            waterways.add(waterwayMap.getTile(loc));
        }
        for(CardinalDirection cd: s.getHalfEdges()){
            Waterway adj = waterwayMap.getTile(loc.getAdjacentLocation(cd.toHexSide()));
            if(adj != null && adj.getWaterwaySides().size() == 6){
                waterways.add(adj);
            }
        }
        return waterways;
    }

    public SectorAdjacencyManager generateSectorAdjacencyManager(){
        SectorAdjacencyManager sam = new SectorAdjacencyManager();
        for(Location loc: getSurfaces().keySet()){
            addLocationToSectorAdjacencyMatrix(loc, sam);
        }
        return sam;
    }

    private void addLocationToSectorAdjacencyMatrix(Location loc, SectorAdjacencyManager sam){
        //HashMap<HexSide, LandTile> adjacents = getAdjacentTiles(loc);
        for(Sector s: getSurfaces().get(loc).getSectors()) {
            sam.add(s, createSectorAdjacency(loc, s));
        }
    }

    private SectorAdjacency createSectorAdjacency(Location loc, Sector s){
        SectorAdjacency sa = new SectorAdjacency();
        for(CardinalDirection cd: s.getHalfEdges()){
            Tile t = getSurfaces().get(loc.getAdjacentLocation(cd.toHexSide()));
            if(t != null){
                sa.add(cd, t.getSectorAtCardinalDirection(cd.getOppositeSide()));
            }
        }
        return sa;
    }

}
