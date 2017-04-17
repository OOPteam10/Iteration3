package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.resources.Fuel;
import model.resources.Iron;
import model.structures.producers.SecondaryProducerTypeB;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class SteamerFactory extends SecondaryProducerTypeB<Iron, Fuel>{

    TransporterManager transporterManager;

    public SteamerFactory(ResourceManager resourceManager, TransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {

    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitSteamerFactory(this);
    }
}
