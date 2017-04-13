package model.resources;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;

/**
 * Created by cduica on 4/9/17.
 */
public class Stone extends Resource {
    public Stone(GoodsManager<Sector, Resource> resourceManager){
        super(resourceManager);
    }

}
