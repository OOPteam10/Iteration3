package model.structures.producers.secondary;

import model.Managers.ResourceManager;
import model.structures.producers.Producer;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class SecondaryProducer extends Producer {

    abstract protected boolean consumeRawResource();

    public SecondaryProducer(ResourceManager resourceManager){
        super(resourceManager);
    }

    public abstract void accept(SecondaryProducerVisitor v);
}
