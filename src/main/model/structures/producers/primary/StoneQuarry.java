package model.structures.producers.primary;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Stone;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class StoneQuarry extends PrimaryProducer {

    public StoneQuarry(ResourceManager resourceManager){
        super(resourceManager);
    }

    @Override
    public void accept(PrimaryProducerVisitor v) {
        v.visitStoneQuarry(this);
    }

    @Override
    public void produce(Sector l) {
        addToResourceManager(l, new Stone());
    }
}
