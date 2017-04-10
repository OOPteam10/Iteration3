package model.MapSubsystem;

import model.Managers.SectorAdjacency;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;

import java.util.HashMap;

/**
 * Created by hankerins on 4/10/17.
 */
public class LandMap extends SurfaceMap<LandTile> {

    public SectorAdjacencyManager generateSectorAdjacencyManager(){
        SectorAdjacencyManager sam = new SectorAdjacencyManager();
        for(Location loc: getSurfaces().keySet()){
            addLocationToSectorAdjacencyMatrix(loc, sam);
        }
        return sam;
    }

    private void addLocationToSectorAdjacencyMatrix(Location loc, SectorAdjacencyManager sam){
        HashMap<HexSide, LandTile> adjacents = getAdjacentTiles(loc);
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
    private HashMap<HexSide, LandTile> getAdjacentTiles(Location location) {
        HashMap<HexSide, LandTile> adjacentTiles =new HashMap<HexSide, LandTile>();
        for(HexSide hs: HexSide.values()){
            LandTile t = getSurfaces().get(location.getAdjacentLocation(hs));
            if(t != null){
                adjacentTiles.put(hs, t);
            }

        }
        return adjacentTiles;
    }
}
