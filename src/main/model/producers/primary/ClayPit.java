package model.producers.primary;

import model.producers.Product;
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
