package model.Managers;

import model.DropOffAbilities.ResourceDropOffAbility;
import model.TileSubsystem.Sector;
import model.resources.Resource;

/**
 * Created by hankerins on 4/12/17.
 */
public class ResourceManager extends ListManager<Sector, Resource> {
    @Override
    public void add(Sector l, Resource r) {
        r.setRdoAbility(new ResourceDropOffAbility(r, this));
        super.add(l, r);
    }
}
