package model.structures.producers.secondary.refinement;

import model.structures.producers.SecondaryProducerTypeB;
import model.resources.Coin;
import model.resources.Paper;
import model.resources.Stock;
import model.structures.producers.Product;

/**
 * Created by cduica on 4/8/17.
 */
public class StockExchange extends SecondaryProducerTypeB<Coin, Paper> {
    @Override
    public Product produce() {
        if(consumeRawResource()){
            return new Stock();
        }
        return null;
    }

}
