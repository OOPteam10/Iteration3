package model;

import model.Managers.*;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Waterway;
import model.Transporters.Transporter;
import model.Wonder.Wonder;
import model.phases.*;
import model.structures.producers.Visitor.ProductVisitor;
import utilities.FileManager.FileManager;
import utilities.TileEditor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 3/22/17.
 */
public class Game implements ManagerSupplier {

    private Map map;
    private PlayerID player1;
    private PlayerID player2;
    private Wonder wonder;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;
    private Transporter currentTransporter;

    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;
    private SeaProducerManager seaProducerManager;

    private ArrayList<Phase> phases = new ArrayList<Phase>();
    private Phase currentPhase;

    private WaterwayToSectorManager waterwayToSectorManager;
    private SectorToWaterwayManager sectorToWaterwayManager;

    //This is non-oop
    private int controlState;

    public Game(){
        map = new Map();
        player1 = new PlayerID();
        player2 = new PlayerID();
        wonder = new Wonder();

        currentTransporter = new Transporter() {
            @Override
            public void dropOff(Sector s) {

            }

            @Override
            public void dropOff(Waterway w) {

            }

            @Override
            public void accept(ProductVisitor v) {

            }
        };

        controlState = 0;
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
        waterwayToSectorManager = map.generateWaterwayToSectorManager();
        sectorToWaterwayManager = map.generateSectorToWaterwayManager();

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
        currentPhase.execute(player1, player2);
    }

    //for testing purposes

    public void executeProductionPhase(){currentPhase.execute();} //only makes sense while we aren't changing phases

    public void startGame(){
        currentPhase = phases.get(0);
    }

    public Phase getCurrentPhase(){
        return currentPhase;
    }

    public ArrayList<Phase> getPhases(){
        return phases;
    }

    public Wonder getWonder(){
        return wonder;
    }

    public PlayerID getPlayer1() {
        return player1;
    }

    public PlayerID getPlayer2() {
        return player2;
    }

    public void setControlState(int controlState){this.controlState = controlState;}

    public int getControlState(){return this.controlState;}

    public void setCurrentTransporter(Transporter transporter){this.currentTransporter = transporter;}

    public Transporter getCurrentTransporter(){return this.currentTransporter;}
}
