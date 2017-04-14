package model.structures.producers.secondary.transportation;

import model.Managers.LandTransporterManager;
import model.Transporters.LandTransporter;
import model.resources.Fuel;
import model.resources.Iron;
import model.structures.producers.Product;
import model.structures.producers.SecondaryProducerTypeB;

/**
 * Created by cduica on 4/8/17.
 */
public class TruckFactory extends SecondaryProducerTypeB<Iron, Fuel> {

    @Override
    public LandTransporter produce() {
        return null;
    }
}
