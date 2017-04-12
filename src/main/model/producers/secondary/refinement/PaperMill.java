package model.producers.secondary.refinement;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeA;
import model.producers.secondary.SecondaryProducerTypeB;
import model.resources.*;

/**
 * Created by cduica on 4/8/17.
 */
public class PaperMill extends SecondaryProducerTypeA<PaperMillResource> {
    @Override
    public Product produce() {
        // Calling this function twice, if not enough resources add consumed resource back.
        if(consumeRawResource()&&consumeRawResource()){
            return new Paper();
        }
        giveResource(new Trunk());
        return null;
    }

}
