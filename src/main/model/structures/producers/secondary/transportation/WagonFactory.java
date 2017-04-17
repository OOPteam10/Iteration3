package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.SectorTransporterManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Wagon;
import model.resources.Board;
import model.resources.Fuel;
import model.resources.Resource;
import model.structures.producers.SecondaryProducerTypeB;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class WagonFactory extends SecondaryProducerTypeB<Board, Fuel> {

    TransporterManager transporterManager;

    public WagonFactory(ResourceManager resourceManager, SectorTransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()) {
            transporterManager.add(new Wagon(), l);
        }
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitWagonFactory(this);
    }

    @Override
    public void visitBoard(Board board) {
        giveResourceA(board);
    }

    //Yes this is wrong but yolo
    @Override
    public void visitFuel(Fuel fuel) {
        giveResourceB(fuel);
    }
}
