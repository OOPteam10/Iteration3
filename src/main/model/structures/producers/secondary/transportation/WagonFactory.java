package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Resource;
import model.structures.producers.SecondaryProducerTypeB;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class WagonFactory extends SecondaryProducerTypeB<Board, Resource> {

    TransporterManager transporterManager;

    public WagonFactory(ResourceManager resourceManager, TransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {

    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitWagonFactory(this);
    }
}
