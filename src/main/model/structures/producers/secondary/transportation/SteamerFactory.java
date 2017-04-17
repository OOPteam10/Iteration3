package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.SectorTransporterManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Steamship;
import model.resources.Fuel;
import model.resources.Iron;
import model.structures.producers.SecondaryProducerTypeB;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class SteamerFactory extends SecondaryProducerTypeB<Iron, Fuel>{

    TransporterManager transporterManager;

    public SteamerFactory(ResourceManager resourceManager, SectorTransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()) {
            transporterManager.add(new Steamship(), l);
        }
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitSteamerFactory(this);
    }

    @Override
    public void visitFuel(Fuel fuel) {
        giveResourceB(fuel);
    }

    @Override
    public void visitIron(Iron iron) {
        giveResourceA(iron);
    }
}
