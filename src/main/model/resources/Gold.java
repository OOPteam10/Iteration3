package model.resources;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;

/**
 * Created by cduica on 4/9/17.
 */
public class Gold extends Resource {
    public Gold(GoodsManager<Sector, Resource> resourceManager){
        super(resourceManager);
    }

}
