package model.producers.primary;

import model.producers.Product;
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
