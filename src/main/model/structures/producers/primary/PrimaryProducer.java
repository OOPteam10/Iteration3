package model.structures.producers.primary;

import model.Managers.ResourceManager;
import model.structures.producers.Producer;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class PrimaryProducer extends Producer {
    public PrimaryProducer(ResourceManager resourceManager){
        super(resourceManager);
    }
}
