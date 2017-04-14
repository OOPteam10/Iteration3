package model.structures.producers.secondary.transportation;

import model.Managers.SeaTransporterManager;
import model.Transporters.SeaTransporter;
import model.resources.Fuel;
import model.resources.Iron;
import model.structures.producers.Product;
import model.structures.producers.SecondaryProducerTypeB;

/**
 * Created by cduica on 4/8/17.
 */
public class SteamerFactory extends SecondaryProducerTypeB<Iron, Fuel>{
    @Override
    public SeaTransporter produce() {
        return null;
    }
}
