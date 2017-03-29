package model.MapSubsystem;

import model.TileSubsystem.HexSide;
import model.TileSubsystem.Tiles.Tile;

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
        if(tiles.containsKey(location))
            return false;
        tiles.put(location, tile);
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
            if(t != null)
                adjacentTiles.put(hs, t);
        }

        return adjacentTiles;
    }

    public HashMap<Location, Tile> getMap(){
        return tiles;
    }
}
