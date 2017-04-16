package model;

import model.Managers.*;

/**
 * Created by hankerins on 4/16/17.
 */
public interface ManagerSupplier {
    public SectorAdjacencyManager getSectorAdjacencyManager();

    public WaterwayAdjacencyManager getWaterwayAdjacencyManager();

    public LandTransporterManager getLandTransporterManager();

    public SectorAdjacencyManager getRoadAdjacencyManager();

    public CargoManager getCargoManager();

    public SeaTransporterManager getSeaTransporterManager();

    public LandPrimaryProducerManager getLandPrimaryProducerManager();

    public LandSecondaryProducerManager getLandSecondaryProducerManager();

    public SeaProducerManager getSeaProducerManager();

    public SeaTransporterShoreManager getSeaTransporterShoreManager();

    public WaterwayToSectorManager getWaterwayToSectorManager();

    public SectorToWaterwayManager getSectorToWaterwayManager();
}
