package model.phases;

import model.Managers.*;
import model.PlayerID;
import model.structures.producers.primary.PrimaryProducer;

/**
 * Created by cduica on 4/14/17.
 */
public class ProductionPhase implements Phase {

    LandPrimaryProducerManager landPrimaryProducerManager;
    LandSecondaryProducerManager landSecondaryProducerManager;
    LandTransporterManager landTransporterManager;
    SeaProducerManager seaProducerManager;
    SeaTransporterManager seaTransporterManager;
    SeaTransporterShoreManager seaTransporterShoreManager;
    CargoManager cargoManager;
    ResourceManager resourceManager;

    public ProductionPhase(LandPrimaryProducerManager landPrimaryProducerManager,
                           LandSecondaryProducerManager landSecondaryProducerManager,
                           LandTransporterManager landTransporterManager, SeaProducerManager seaProducerManager,
                           SeaTransporterManager seaTransporterManager, SeaTransporterShoreManager seaTransporterShoreManager,
                           CargoManager cargoManager, ResourceManager resourceManager) {
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
    public void execute(PlayerID p1, PlayerID p2) {
        iterateLandProducers();
        iterateSeaProducers();
    }

    private void iterateLandProducers(){
        //TODO some logic with placing the product
        landPrimaryProducerManager.produceAll();
        //landSecondaryProducerManager.produceAll();
    }

    private void iterateSeaProducers(){
        seaProducerManager.produceAll();
    }

}
