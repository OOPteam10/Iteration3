package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.structures.producers.SecondaryProducerTypeB;

/**
 * Created by cduica on 4/8/17.
 */
public class WagonFactory extends SecondaryProducerTypeB<Board, Object> {

    TransporterManager transporterManager;

    public WagonFactory(ResourceManager resourceManager, TransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {

    }
}
