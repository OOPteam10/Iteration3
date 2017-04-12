package model.producers.secondary;

import model.producers.Producer;
import model.resources.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class SecondaryProducer extends Producer {

    abstract protected boolean consumeRawResource();

}
