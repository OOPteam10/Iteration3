package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.Tile;
import utilities.TileEditor;

import java.util.HashMap;

/**
 * Created by cduica on 3/22/17.
 */
public class Game {

    private Map map;
    //private Player player

    public Game(){
        map = new Map();
        //instantiate tile editor
        TileEditor.getInstance().init(map);
    }

    public HashMap<Location, Tile> getMap(){
        return map.getMap();
    }
    public void setMap(HashMap<Location, Tile> gameMap){this.map.setMap(gameMap);}
}
