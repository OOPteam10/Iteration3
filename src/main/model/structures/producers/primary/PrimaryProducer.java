package model.structures.producers.primary;

import model.Managers.ResourceManager;
import model.structures.producers.Producer;
import model.structures.producers.Visitor.PrimaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class PrimaryProducer extends Producer {
    public PrimaryProducer(ResourceManager resourceManager){
        super(resourceManager);
    }

    public abstract void accept(PrimaryProducerVisitor v);
}
