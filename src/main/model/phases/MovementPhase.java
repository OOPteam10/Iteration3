package model.phases;

import model.Game;
import model.Managers.*;
import model.PlayerID;

/**
 * Created by cduica on 4/15/17.
 */
public class MovementPhase implements Phase {

    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;

    public MovementPhase(LandTransporterManager landTransporterManager,
                         SeaTransporterManager seaTransporterManager,
                         SeaTransporterShoreManager seaTransporterShoreManager,
                         ResourceManager resourceManager,
                         CargoManager cargoManager,
                         SectorAdjacencyManager sectorAdjacencyManager,
                         SectorAdjacencyManager roadAdjacencyManager,
                         WaterwayAdjacencyManager waterwayAdjacencyManager) {
        this.landTransporterManager = landTransporterManager;
        this.seaTransporterManager = seaTransporterManager;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
        this.resourceManager = resourceManager;
        this.cargoManager = cargoManager;
        this.sectorAdjacencyManager = sectorAdjacencyManager;
        this.roadAdjacencyManager = roadAdjacencyManager;
        this.waterwayAdjacencyManager = waterwayAdjacencyManager;
    }

    @Override
    public void execute(PlayerID p1, PlayerID p2) {
        execute(p1);
        execute(p2);
    }

    @Override
    public void execute(PlayerID playerID) {

    }
}
