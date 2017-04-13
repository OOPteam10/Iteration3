package model.DropOffAbilities;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Resource;

/**
 * Created by hankerins on 4/12/17.
 */
public class ResourceDropOffAbility implements DropOffAbility<Sector> {
    Resource resource;
    GoodsManager<Sector, Resource> resourceManager;



    public ResourceDropOffAbility(Resource resource,  GoodsManager<Sector, Resource> resourceManager){
        this.resource = resource;
        this.resourceManager = resourceManager;
    }

    public void execute(Sector s){
        resourceManager.add(s, resource);
    }
}
