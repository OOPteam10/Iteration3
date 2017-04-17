package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by Kevin on 4/16/17.
 */

public class IronSpecializedMine extends Mine{

    public IronSpecializedMine(ResourceManager resourceManager){
        super(resourceManager);

        setIronCount(4);
        setGoldCount(0);
    }

    @Override
    public void accept(PrimaryProducerVisitor v) {

    }

}
