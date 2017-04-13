package model.structures.producers;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.structures.Structure;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class Producer extends Structure {

    public abstract Product produce();
    //Some member variables for production limits go here


}
