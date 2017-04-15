package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Coin;
import model.resources.Paper;
import model.resources.Stock;
import model.structures.producers.SecondaryProducerTypeB;

/**
 * Created by cduica on 4/8/17.
 */
public class StockExchange extends SecondaryProducerTypeB<Coin, Paper> {

    public StockExchange(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            addToResourceManager(l, new Stock());
        }

    }

}
