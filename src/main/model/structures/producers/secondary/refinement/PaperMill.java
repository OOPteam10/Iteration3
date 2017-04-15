package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.structures.producers.SecondaryProducerTypeA;
import model.resources.Paper;
import model.resources.PaperMillResource;
import model.resources.Trunk;

/**
 * Created by cduica on 4/8/17.
 */
public class PaperMill extends SecondaryProducerTypeA<PaperMillResource> {

    public PaperMill(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public void produce(Sector l) {
        // Calling this function twice, if not enough resources add consumed resource back.
        if(consumeRawResource()&&consumeRawResource()){
            addToResourceManager(l , new Paper());
        } else {
            giveResource(new Trunk());
        }
    }

}
