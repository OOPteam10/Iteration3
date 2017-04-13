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

    public void setRdoAbility(ResourceDropOffAbility rdoAbility) {
        this.rdoAbility = rdoAbility;
    }

    @Override
    public void dropOff(Sector s) {
        rdoAbility.execute(s);
    }
}
