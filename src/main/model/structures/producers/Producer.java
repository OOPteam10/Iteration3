package model.structures.producers;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.structures.Structure;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class Producer extends Structure {

    private ResourceManager resourceManager;

    public Producer(ResourceManager resourceManager){
        this.resourceManager = resourceManager;
    }

    public abstract void produce(Sector l);

    protected void addToResourceManager( Sector l, Resource r ){
        resourceManager.add(l, r);
    }

}
