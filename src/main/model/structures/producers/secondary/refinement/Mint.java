package model.structures.producers.secondary.refinement;


import model.structures.producers.SecondaryProducerTypeB;
import model.resources.Coin;
import model.resources.Fuel;
import model.resources.Gold;
import model.structures.producers.Product;

/**
 * Created by cduica on 4/8/17.
 */
public class Mint extends SecondaryProducerTypeB<Gold, Fuel> {
    @Override
    public Product produce() {
        if(consumeRawResource()){
            return new Coin();
        }
        return null;
    }

}
