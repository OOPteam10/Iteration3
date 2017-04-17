package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by Kevin on 4/16/17.
 */

public class GoldSpecializedMine extends Mine{

    public GoldSpecializedMine(ResourceManager resourceManager){
        super(resourceManager);

        setIronCount(0);
        setGoldCount(4);
    }

    @Override
    public void accept(PrimaryProducerVisitor v) {

    }

}
