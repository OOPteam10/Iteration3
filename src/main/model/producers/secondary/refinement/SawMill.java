package model.producers.secondary.refinement;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeA;
import model.resources.Board;
import model.resources.Resource;
import model.resources.Trunk;

/**
 * Created by cduica on 4/8/17.
 */
public class SawMill extends SecondaryProducerTypeA<Trunk> {
    @Override
    public Product produce() {
        if(consumeRawResource()){
            return new Board();
        }
        return null;
    }

}
