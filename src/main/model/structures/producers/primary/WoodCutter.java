package model.structures.producers.primary;


import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Trunk;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class WoodCutter extends PrimaryProducer {

    public WoodCutter(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void accept(PrimaryProducerVisitor v) {
        v.visitWoodCutter(this);
    }

    @Override
    public void produce(Sector l) {
        addToResourceManager(l, new Trunk());
    }
}
