package model.structures.producers.secondary.refinement;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.*;
import model.structures.producers.SecondaryProducerTypeA;

/**
 * Created by cduica on 4/8/17.
 */
public class CoalBurner extends SecondaryProducerTypeA<Resource> {

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

    @Override
    public void visitBoard(Board board){
        giveResource(board);
    }

    @Override
    public void visitTrunk(Trunk trunk){
        giveResource(trunk);
    }

}
