package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;
import model.structures.producers.primary.PrimaryProducer;

/**
 * Created by cduica on 4/9/17.
 */
public abstract class Mine extends PrimaryProducer{

    /**
     * This is for people who did mines to work on lol
     */
    public Mine(ResourceManager resourceManager) {
        super(resourceManager);
    }
}
