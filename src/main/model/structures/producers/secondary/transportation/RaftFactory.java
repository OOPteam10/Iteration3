package model.structures.producers.secondary.transportation;

import model.Managers.SeaTransporterManager;
import model.Managers.TransporterManager;
import model.Transporters.Donkey;
import model.Transporters.SeaTransporter;
import model.Transporters.Transporter;
import model.resources.Trunk;
import model.structures.producers.Product;
import model.structures.producers.SecondaryProducerTypeA;

/**
 * Created by cduica on 4/8/17.
 */
public class RaftFactory extends SecondaryProducerTypeA<Trunk> {
    @Override
    public SeaTransporter produce() {
        return null;
    }
}
