package model;

import model.Managers.*;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.Tile;
import model.Transporters.LandTransporter;
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
    private SectorAdjacencyManager sectorAdjacencyManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    public Game(){
        map = new Map();
        //instantiate tile editor
        TileEditor.getInstance().init(map);
        setDefaultMap();
        map.formatSurfaceMaps();
        sectorAdjacencyManager = map.generateSectorAdjacencyManager();
        roadAdjacencyManager = new SectorAdjacencyManager();
        waterwayAdjacencyManager = map.generateWaterwayAdjacencyManager();
        landTransporterManager = new LandTransporterManager();
        seaTransporterManager = new SeaTransporterManager();
        resourceManager = new ResourceManager();
        cargoManager = new CargoManager();
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

    public SectorAdjacencyManager getSectorAdjacencyManager(){
        return sectorAdjacencyManager;
    }

    public WaterwayAdjacencyManager getWaterwayAdjacencyManager(){
        return waterwayAdjacencyManager;
    }

    public LandTransporterManager getLandTransporterManager(){
        return landTransporterManager;
    }

    public SectorAdjacencyManager getRoadAdjacencyManager() {return roadAdjacencyManager;}

    public ResourceManager getResourceManager() {return resourceManager;}

    public CargoManager getCargoManager() {return cargoManager;}

    public SeaTransporterManager getSeaTransporterManager() {
        return seaTransporterManager;
    }
}
