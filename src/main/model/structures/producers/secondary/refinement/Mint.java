package model.structures.producers.secondary.refinement;


import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.structures.producers.SecondaryProducerTypeB;
import model.resources.Coin;
import model.resources.Fuel;
import model.resources.Gold;

/**
 * Created by cduica on 4/8/17.
 */
public class Mint extends SecondaryProducerTypeB<Gold, Fuel> {

    public Mint(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            addToResourceManager(l, new Coin());
        }
    }

}
