package model.producers.secondary;

import model.producers.Producer;
import model.resources.Resource;

import java.util.List;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class SecondaryProducer extends Producer {

    List<Resource> rawResources;

    public abstract void giveResource(Resource resource);
}
