package model.structures.producers;

import model.Managers.ResourceManager;
import model.resources.Resource;
import model.structures.producers.secondary.SecondaryProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/10/17.
 */
public abstract class SecondaryProducerTypeA<T extends Resource> extends SecondaryProducer {

    private List<T> rawResources = new ArrayList<>();

    public SecondaryProducerTypeA(ResourceManager resourceManager) {
        super(resourceManager);
    }

    public void giveResource(T resource){
        rawResources.add(resource);
    }

    @Override
    protected boolean consumeRawResource() {
        if(rawResources.isEmpty()){
            return false;
        }
        T toRemove = rawResources.get(rawResources.size() - 1);
        removeFromResourceManager(toRemove);
        rawResources.remove(toRemove);
        return true;
    }

}
