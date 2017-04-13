package model.structures.producers;

import model.structures.producers.secondary.SecondaryProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/10/17.
 */
public abstract class SecondaryProducerTypeB<T1, T2> extends SecondaryProducer {

    private List<T1> rawResourceA = new ArrayList<>();
    private List<T2> rawResourceB = new ArrayList<>();

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
        rawResourceA.remove(rawResourceA.size() - 1);
        rawResourceB.remove(rawResourceB.size() - 1);
        return true;
    }
}
