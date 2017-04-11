package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.Tile;
import utilities.FileManager.FileManager;
import utilities.TileEditor;

import java.io.IOException;
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
        setDefaultMap();
    }

    public HashMap<Location, Tile> getMap(){//TODO: REFACTOR!
        return map.getMap();
    }

    public Map getActualMap(){//TODO: REFACTOR!
        return map;
    }

    public void setDefaultMap(){
        FileManager fileManager = new FileManager();
        try {
            setMap(fileManager.loadDefaultMap());
        }catch (IOException e){
            System.out.println("No default.txt found");
        }
    }
    public void setMap(HashMap<Location, Tile> gameMap){this.map.setMap(gameMap);}
}
