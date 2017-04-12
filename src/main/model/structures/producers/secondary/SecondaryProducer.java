package model.structures.producers.secondary;

import model.structures.producers.Producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class SecondaryProducer<T> extends Producer {

    List<T> rawResources = new ArrayList<>();

    public void giveResource(T resource){
        rawResources.add(resource);
    }
}
