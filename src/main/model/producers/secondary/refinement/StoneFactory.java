package model.producers.secondary.refinement;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeA;
import model.resources.Clay;
import model.resources.Resource;
import model.resources.Stone;

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
