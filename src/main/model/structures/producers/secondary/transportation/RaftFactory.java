package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.SeaTransporterShoreManager;
import model.Managers.SectorTransporterManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Raft;
import model.resources.Trunk;
import model.structures.producers.SecondaryProducerTypeA;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class RaftFactory extends SecondaryProducerTypeA<Trunk> {

    TransporterManager transporterManager;

    public RaftFactory(ResourceManager resourceManager, SectorTransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            transporterManager.add(new Raft(), l);
        }
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitRaftFactory(this);
    }

    @Override
    public void visitTrunk(Trunk trunk) {
        giveResource(trunk);
    }
}
