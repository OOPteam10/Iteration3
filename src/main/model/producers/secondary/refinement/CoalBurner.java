package model.producers.secondary.refinement;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeA;
import model.producers.secondary.SecondaryProducerTypeB;
import model.resources.*;

/**
 * Created by cduica on 4/8/17.
 */
public class CoalBurner extends SecondaryProducerTypeA<CoalBurnerResource> {

    @Override
    public Product produce() {
        if(consumeRawResource()&&consumeRawResource()){
            return new Fuel();
        }
        giveResource(new Trunk());
        return null;
    }

}
