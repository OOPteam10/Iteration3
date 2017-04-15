package model.structures.producers.primary;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.structures.producers.Product;
import model.resources.Stone;

/**
 * Created by cduica on 4/8/17.
 */
public class StoneQuarry extends PrimaryProducer {

    public StoneQuarry(ResourceManager resourceManager){
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        addToResourceManager(l, new Stone());
    }
}
