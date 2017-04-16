package model.phases;

import model.Game;
import model.Managers.*;
import model.PlayerID;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;

/**
 * Created by cduica on 4/14/17.
 */
public class ProductionPhase implements Phase {

    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;
    private LandTransporterManager landTransporterManager;
    private SeaProducerManager seaProducerManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private CargoManager cargoManager;
    private ResourceManager resourceManager;

    public ProductionPhase(LandPrimaryProducerManager landPrimaryProducerManager,
                           LandSecondaryProducerManager landSecondaryProducerManager,
                           LandTransporterManager landTransporterManager,
                           SeaProducerManager seaProducerManager,
                           SeaTransporterManager seaTransporterManager,
                           SeaTransporterShoreManager seaTransporterShoreManager,
                           CargoManager cargoManager,
                           ResourceManager resourceManager) {
        this.landPrimaryProducerManager = landPrimaryProducerManager;
        this.landSecondaryProducerManager = landSecondaryProducerManager;
        this.landTransporterManager = landTransporterManager;
        this.seaProducerManager = seaProducerManager;
        this.seaTransporterManager = seaTransporterManager;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
        this.cargoManager = cargoManager;
        this.resourceManager = resourceManager;
    }

    @Override
    public void execute(PlayerID p1, PlayerID p2, Game context) {
        iterateLandProducers();
        //iterateSeaProducers();
        execute(p1);
        execute(p2);
        context.startNextPhase();
    }

    private void iterateLandProducers(){
        //TODO some logic with placing the product
        landPrimaryProducerManager.produceAll();
        //landSecondaryProducerManager.produceAll();
    }

    private void iterateSeaProducers(){
        seaProducerManager.produceAll();
    }

    @Override
    public void execute(PlayerID playerID) {

    }

}
