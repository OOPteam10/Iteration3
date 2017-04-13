package model.MapSubsystem;

import model.Managers.SectorAdjacency;
import model.Managers.WaterwayAdjacency;
import model.Managers.WaterwayAdjacencyManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Waterway;

import java.util.HashMap;

/**
 * Created by hankerins on 4/10/17.
 */
public class WaterwayMap extends SurfaceMap<Waterway> {

    public WaterwayAdjacencyManager generateWaterwayAdjacencyManager(){
        WaterwayAdjacencyManager wam = new WaterwayAdjacencyManager();
        for(Location loc: getSurfaces().keySet()){
            addLocationToWaterwayAdjacencyManager(loc, wam);
        }
        return wam;
    }

    private void addLocationToWaterwayAdjacencyManager(Location loc, WaterwayAdjacencyManager wam){
        //HashMap<HexSide, Waterway> adjacents = getAdjacentWaterways(loc);
        Waterway w = getSurfaces().get(loc);
        wam.add(w, createWaterwayAdjacency(loc, w));

    }

    private WaterwayAdjacency createWaterwayAdjacency(Location loc, Waterway w){
        WaterwayAdjacency wa = new WaterwayAdjacency();
        for(HexSide hs: w.getWaterwaySides()){
            Waterway adj = getSurfaces().get(loc.getAdjacentLocation(hs));
            if(adj != null && adj.contains(hs.getOppositeSide())){
                wa.add(hs, adj);
            }
        }
        return wa;
    }


    public HashMap<HexSide, Waterway> getAdjacentWaterways(Location location) {
        HashMap<HexSide, Waterway> adjacentWaterways =new HashMap<HexSide, Waterway>();
        for(HexSide hs: HexSide.values()){
            Waterway waterway = getSurfaces().get(location.getAdjacentLocation(hs));
            if(waterway != null && waterway.contains(hs.getOppositeSide())){ //UGLY CONDITIONAL LOGIC
                adjacentWaterways.put(hs, waterway);
            }

        }
        return adjacentWaterways;
    }
}
