package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.structures.producers.SecondaryProducerTypeA;
import model.resources.Clay;
import model.resources.Stone;

/**
 * Created by cduica on 4/8/17.
 */
public class StoneFactory extends SecondaryProducerTypeA<Clay> {

    public StoneFactory(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            addToResourceManager(l, new Stone());
        }
    }

}
