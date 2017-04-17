package model.structures.producers;

import model.Managers.ResourceManager;
import model.resources.Resource;
import model.structures.producers.secondary.SecondaryProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/10/17.
 */
public abstract class SecondaryProducerTypeB<T1 extends Resource, T2 extends Resource> extends SecondaryProducer {

    private List<T1> rawResourceA = new ArrayList<>();
    private List<T2> rawResourceB = new ArrayList<>();

    public SecondaryProducerTypeB(ResourceManager resourceManager) {
        super(resourceManager);
    }

    public void giveResourceA(T1 resource){
        rawResourceA.add(resource);
    }

    public void giveResourceB(T2 resource){
        rawResourceB.add(resource);
    }

    @Override
    protected boolean consumeRawResource() {
        if(rawResourceA.isEmpty() || rawResourceB.isEmpty()){
            return false;
        }
        T1 toRemoveA = rawResourceA.get(rawResourceA.size() - 1);
        T2 toRemoveB = rawResourceB.get(rawResourceB.size() - 1);

        rawResourceA.remove(toRemoveA);
        rawResourceB.remove(toRemoveB);
        removeFromResourceManager(toRemoveA);
        removeFromResourceManager(toRemoveB);
        return true;
    }
}
