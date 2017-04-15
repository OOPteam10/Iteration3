package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.structures.producers.SecondaryProducerTypeA;
import model.resources.CoalBurnerResource;
import model.resources.Fuel;
import model.resources.Trunk;

/**
 * Created by cduica on 4/8/17.
 */
public class CoalBurner extends SecondaryProducerTypeA<CoalBurnerResource> {

    public CoalBurner(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()&&consumeRawResource()){
            addToResourceManager(l, new Fuel());
        } else {
            giveResource(new Trunk());
        }
    }

}
