package model;

import model.Managers.*;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.Tile;
import model.phases.*;
import utilities.FileManager.FileManager;
import utilities.TileEditor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 3/22/17.
 */
public class Game {

    private Map map;
    private PlayerID player1;
    private PlayerID player2;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;
    private SeaProducerManager seaProducerManager;

    private ArrayList<Phase> phases;
    private Phase currentPhase;

    private ProductionPhase productionPhase;

    private WaterwayToSectorManager waterwayToSectorManager;
    private SectorToWaterwayManager sectorToWaterwayManager;


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
        seaTransporterShoreManager = new SeaTransporterShoreManager();
        resourceManager = new ResourceManager();
        cargoManager = new CargoManager();

        landPrimaryProducerManager = new LandPrimaryProducerManager();
        landSecondaryProducerManager = new LandSecondaryProducerManager();
        //seaProducerManager = new SeaProducerManager();

        phases.add( new ProductionPhase(landPrimaryProducerManager, landSecondaryProducerManager,
                landTransporterManager, seaProducerManager, seaTransporterManager, seaTransporterShoreManager,
                cargoManager, resourceManager) );
        phases.add( new MovementPhase(landTransporterManager, seaTransporterManager, seaTransporterShoreManager,
                resourceManager, cargoManager, sectorAdjacencyManager, roadAdjacencyManager, waterwayAdjacencyManager) );
        phases.add( new BuildingPhase(landPrimaryProducerManager, landSecondaryProducerManager, landTransporterManager,
                seaProducerManager, seaTransporterManager, seaTransporterShoreManager, cargoManager, resourceManager,
                sectorAdjacencyManager, roadAdjacencyManager, waterwayAdjacencyManager) );
        phases.add( new WonderPhase(landTransporterManager, resourceManager, seaTransporterShoreManager, cargoManager) );

        currentPhase = phases.get(0);
        waterwayToSectorManager = map.generateWaterwayToSectorManager();
        sectorToWaterwayManager = map.generateSectorToWaterwayManager();

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
            setMap(FileManager.loadDefaultMap());
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

    public LandPrimaryProducerManager getLandPrimaryProducerManager() {
        return landPrimaryProducerManager;
    }

    public LandSecondaryProducerManager getLandSecondaryProducerManager() {
        return landSecondaryProducerManager;
    }

    public SeaProducerManager getSeaProducerManager() {
        return seaProducerManager;
    }

    public SeaTransporterShoreManager getSeaTransporterShoreManager() {return seaTransporterShoreManager;}

    public WaterwayToSectorManager getWaterwayToSectorManager() {return waterwayToSectorManager;}

    public SectorToWaterwayManager getSectorToWaterwayManager() {return sectorToWaterwayManager;}

    public void startNextPhase(){
        int next = (phases.indexOf(currentPhase)+1) % phases.size();
        currentPhase = phases.get(next);
        currentPhase.execute(player1, player2, this);
    }

}
