package model.structures.producers.primary;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.structures.producers.Product;
import model.resources.Trunk;

/**
 * Created by cduica on 4/8/17.
 */
public class WoodCutter extends PrimaryProducer {
    @Override
    public Product produce(GoodsManager<Sector, Resource> resourceManager) {
        return new Trunk(resourceManager);
    }
}
