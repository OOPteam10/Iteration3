package model.phases;

import model.Game;
import model.Managers.*;
import model.PlayerID;

/**
 * Created by cduica on 4/15/17.
 */
public class BuildingPhase implements Phase {

    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;
    private LandTransporterManager landTransporterManager;
    private SeaProducerManager seaProducerManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private CargoManager cargoManager;
    private ResourceManager resourceManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;

    public BuildingPhase(LandPrimaryProducerManager landPrimaryProducerManager,
                         LandSecondaryProducerManager landSecondaryProducerManager,
                         LandTransporterManager landTransporterManager,
                         SeaProducerManager seaProducerManager,
                         SeaTransporterManager seaTransporterManager,
                         SeaTransporterShoreManager seaTransporterShoreManager,
                         CargoManager cargoManager, ResourceManager resourceManager,
                         SectorAdjacencyManager sectorAdjacencyManager,
                         SectorAdjacencyManager roadAdjacencyManager,
                         WaterwayAdjacencyManager waterwayAdjacencyManager) {
        this.landPrimaryProducerManager = landPrimaryProducerManager;
        this.landSecondaryProducerManager = landSecondaryProducerManager;
        this.landTransporterManager = landTransporterManager;
        this.seaProducerManager = seaProducerManager;
        this.seaTransporterManager = seaTransporterManager;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
        this.cargoManager = cargoManager;
        this.resourceManager = resourceManager;
        this.sectorAdjacencyManager = sectorAdjacencyManager;
        this.roadAdjacencyManager = roadAdjacencyManager;
        this.waterwayAdjacencyManager = waterwayAdjacencyManager;
    }

    @Override
    public void execute(PlayerID p1, PlayerID p2, Game context) {
        execute(p1);
        execute(p2);
        context.startNextPhase();
    }

    @Override
    public void execute(PlayerID playerID) {

    }
}
