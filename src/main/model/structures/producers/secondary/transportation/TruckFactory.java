package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.SectorTransporterManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Truck;
import model.resources.Fuel;
import model.resources.Iron;
import model.structures.producers.SecondaryProducerTypeB;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class TruckFactory extends SecondaryProducerTypeB<Iron, Fuel> {

    TransporterManager transporterManager;

    public TruckFactory(ResourceManager resourceManager, SectorTransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()) {
            transporterManager.add(new Truck(), l);
        }
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitTruckFactory(this);
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
