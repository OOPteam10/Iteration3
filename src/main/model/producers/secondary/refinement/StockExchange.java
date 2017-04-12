package model.producers.secondary.refinement;

import model.producers.Product;
import model.producers.secondary.SecondaryProducerTypeB;
import model.resources.Coin;
import model.resources.Paper;
import model.resources.Stock;

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
