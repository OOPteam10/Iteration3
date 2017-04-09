package model.producers.primary;

import model.producers.Product;
import model.resources.Fuel;

/**
 * Created by cduica on 4/8/17.
 */
public class OilRig extends PrimaryProducer {
    @Override
    public Product produce() {
        return new Fuel();
    }
}
