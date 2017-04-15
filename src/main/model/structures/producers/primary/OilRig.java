package model.structures.producers.primary;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Fuel;

/**
 * Created by cduica on 4/8/17.
 */
public class OilRig extends PrimaryProducer {

    public OilRig(ResourceManager resourceManager){
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        addToResourceManager(l, new Fuel());
    }
}
