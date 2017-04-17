package model.structures.producers.secondary.refinement;


import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Trunk;
import model.structures.producers.SecondaryProducerTypeA;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class SawMill extends SecondaryProducerTypeA<Trunk> {

    public SawMill(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitSawMill(this);
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            addToResourceManager(l, new Board());
        }
    }

    @Override
    public void visitTrunk(Trunk trunk){
        giveResource(trunk);
    }

}
