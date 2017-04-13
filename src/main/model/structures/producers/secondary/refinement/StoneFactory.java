package model.structures.producers.secondary.refinement;

import model.structures.producers.SecondaryProducerTypeA;
import model.resources.Clay;
import model.resources.Stone;
import model.structures.producers.Product;

/**
 * Created by cduica on 4/8/17.
 */
public class StoneFactory extends SecondaryProducerTypeA<Clay> {
    @Override
    public Product produce() {
        if(consumeRawResource()){
            return new Stone();
        }
        return null;
    }

}
