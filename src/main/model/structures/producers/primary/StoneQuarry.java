package model.structures.producers.primary;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.structures.producers.Product;
import model.resources.Stone;

/**
 * Created by cduica on 4/8/17.
 */
public class StoneQuarry extends PrimaryProducer {
    @Override
    public Product produce() {
        return new Stone();
    }
}
