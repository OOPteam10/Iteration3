package model.structures.producers.primary;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.structures.producers.Product;
import model.resources.Clay;

/**
 * Created by cduica on 4/8/17.
 */
public class ClayPit extends PrimaryProducer {
    @Override
    public Product produce() {
        return new Clay();
    }
}
