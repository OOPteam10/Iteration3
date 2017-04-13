package model.structures.producers.secondary.refinement;

import model.structures.producers.SecondaryProducerTypeA;
import model.resources.Paper;
import model.resources.PaperMillResource;
import model.resources.Trunk;
import model.structures.producers.Product;

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
