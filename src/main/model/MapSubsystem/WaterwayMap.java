package model.MapSubsystem;

import model.Managers.*;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Waterway;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/10/17.
 */
public class WaterwayMap extends SurfaceMap<Waterway> {

    public WaterwayToSectorManager generateWaterwayToSectorManager(LandMap landMap){
        WaterwayToSectorManager wtsm = new WaterwayToSectorManager();
        for(Location loc: getSurfaces().keySet()){
            addLocationToWaterwayToSectorManager(loc, wtsm, landMap);
        }
        return wtsm;
    }

    private void addLocationToWaterwayToSectorManager(Location loc, WaterwayToSectorManager wtsm, LandMap landMap){
        //HashMap<HexSide, LandTile> adjacents = getAdjacentTiles(loc);

        wtsm.add(getTile(loc), createSectorList(loc, landMap));

    }

    private ArrayList<Sector> createSectorList(Location loc, LandMap landMap){
        ArrayList<Sector> sectors = new ArrayList<Sector>();
        //handle river
        if(getTile(loc).getWaterwaySides().size() < 6){
            for(Sector s: landMap.getTile(loc).getSectors()){
                sectors.add(s);
            }
        }
        //handle sea tiles
        else{
            for(HexSide hs: HexSide.values()){
                LandTile lt = landMap.getTile(loc.getAdjacentLocation(hs));
                if(lt != null){
                    sectors.add(lt.getSectorAtCardinalDirection(hs.getFirstHalf().getOppositeSide()));
                    sectors.add(lt.getSectorAtCardinalDirection(hs.getSecondHalf().getOppositeSide()));
                }
            }
        }
        return sectors;
    }

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
}
