package model.producers.secondary.transportation;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeB;
import model.resources.Fuel;
import model.resources.Iron;
import model.resources.Resource;

/**
 * Created by cduica on 4/8/17.
 */
public class TruckFactory extends SecondaryProducerTypeB<Iron, Fuel> {
    @Override
    public Product produce() {
        return null;
    }

}
