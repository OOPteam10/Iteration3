package model.MapSubsystem;

import model.TileSubsystem.HexSide;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.RiverTileValidationVisitor;

import java.util.HashMap;

/**
 * Created by hankerins on 3/26/17.
 */
public class Map {
    HashMap<Location, Tile> tiles;

    public Map(){
        tiles = new HashMap<Location, Tile>();
    }

    public boolean addTile(Tile tile, Location location){
        boolean valid;
        if(tiles.containsKey(location)){
            System.out.println("already tile there\n");
            return false;
        }

        //TODO: get rid of instanceof and have functions for both kinds of tiles
        if(tile instanceof RiverTile){
            System.out.println("Map->addTile()-> instanceof rivertile\n");
            valid = validateRiverTilePlacement( (RiverTile)tile,  location);
            if (!valid){
                return valid;
            }

        }
        tiles.put(location, tile);
        System.out.println("map.addTile() succeeds\n");
        return true;
    }
    public Tile getTile(Location location){
        return tiles.get(location);
    }

    //getAdjacentTiles could return a HashMap<CardinalDirection, Tile> so that you know where
    //the adjacent tiles are in reference to the location passed as argument

    /*public HashMap<Location, Tile> getAdjacentTiles(Location location) {
        HashMap<Location, Tile> adjacentTiles =new HashMap<Location, Tile>();
        for(Location l: location.getAdjacentLocations()){
            Tile t = tiles.get(l);
            if(t != null)
                adjacentTiles.put(l, t);
        }
        return adjacentTiles;
    }*/
    public HashMap<HexSide, Tile> getAdjacentTiles(Location location) {
        HashMap<HexSide, Tile> adjacentTiles =new HashMap<HexSide, Tile>();
        for(HexSide hs: HexSide.values()){
            Tile t = tiles.get(location.getAdjacentLocation(hs));
            if(t != null){
                adjacentTiles.put(hs, t);
            }

        }
        return adjacentTiles;
    }

    public boolean validateRiverTilePlacement(RiverTile riverTile, Location location){
        boolean isValid = true;
        HashMap<HexSide, Tile> adjacentTiles = getAdjacentTiles(location);
        for(HexSide hs: adjacentTiles.keySet()){
            RiverTileValidationVisitor visitor = new RiverTileValidationVisitor(riverTile, hs);
            adjacentTiles.get(hs).accept(visitor);
            if(!visitor.isValid())
                isValid = false;
            //validate the tile at this hexside with the source tile
        }
        return isValid;
    }

    public HashMap<Location, Tile> getMap(){
        return tiles;
    }
}
