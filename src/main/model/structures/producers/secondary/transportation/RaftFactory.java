package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.resources.Trunk;
import model.structures.producers.SecondaryProducerTypeA;

/**
 * Created by cduica on 4/8/17.
 */
public class RaftFactory extends SecondaryProducerTypeA<Trunk> {

    TransporterManager transporterManager;

    public RaftFactory(ResourceManager resourceManager, TransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {

    }
}
