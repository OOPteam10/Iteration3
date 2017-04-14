package model.structures.producers.secondary.refinement;

import model.structures.producers.SecondaryProducerTypeA;
import model.resources.CoalBurnerResource;
import model.resources.Fuel;
import model.resources.Trunk;
import model.structures.producers.Product;

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
