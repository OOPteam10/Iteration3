package model.structures.producers.secondary.refinement;


import model.structures.producers.SecondaryProducerTypeA;
import model.resources.Board;
import model.resources.Trunk;
import model.structures.producers.Product;

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
