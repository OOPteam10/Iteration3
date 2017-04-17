package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by Kevin on 4/16/17.
 */

public class BigMine extends Mine{

    public BigMine(ResourceManager resourceManager){
        super(resourceManager);

        ironCount = 5;
        goldCount = 5;

    }

    @Override
    public void accept(PrimaryProducerVisitor v) {

    }

}