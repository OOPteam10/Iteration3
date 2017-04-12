package model.producers.secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/10/17.
 */
public abstract class SecondaryProducerTypeA<T> extends SecondaryProducer{

    private List<T> rawResources = new ArrayList<>();

    public void giveResource(T resource){
        rawResources.add(resource);
    }

    @Override
    protected boolean consumeRawResource() {
        if(rawResources.isEmpty()){
            return false;
        }

        rawResources.remove(rawResources.size() - 1);
        return true;
    }
}
