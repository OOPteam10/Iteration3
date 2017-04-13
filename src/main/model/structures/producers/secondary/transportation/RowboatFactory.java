package model.structures.producers.secondary.transportation;

import model.Managers.SeaTransporterManager;
import model.Transporters.SeaTransporter;
import model.resources.Board;
import model.structures.producers.Product;
import model.structures.producers.SecondaryProducerTypeA;

/**
 * Created by cduica on 4/8/17.
 */
public class RowboatFactory extends SecondaryProducerTypeA<Board> {
    @Override
    public SeaTransporter produce() {
        return null;
    }
}
