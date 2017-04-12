package model.resources;

import model.DropOffAbilities.ResourceDropOffAbility;
import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.structures.producers.Product;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class Resource implements Product<Sector> {

    ResourceDropOffAbility rdoAbility;

    public Resource(GoodsManager<Sector, Resource> resourceManager){
        rdoAbility = new ResourceDropOffAbility(this, resourceManager);
    }

    @Override
    public void dropOff(Sector s) {
        rdoAbility.execute(s);
    }
}
