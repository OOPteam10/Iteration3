package model.resources;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;

/**
 * Created by cduica on 4/9/17.
 */
public class Stock extends Resource {
    public Stock(GoodsManager<Sector, Resource> resourceManager){
        super(resourceManager);
    }

}
