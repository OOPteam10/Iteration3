package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.*;
import model.structures.producers.SecondaryProducerTypeA;

/**
 * Created by cduica on 4/8/17.
 */
public class PaperMill extends SecondaryProducerTypeA<Resource> {

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

    @Override
    public void visitBoard(Board board){
        giveResource(board);
    }

    @Override
    public void visitTrunk(Trunk trunk){
        giveResource(trunk);
    }

}
