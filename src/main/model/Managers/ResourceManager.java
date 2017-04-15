package model.Managers;

import model.DropOffAbilities.ResourceDropOffAbility;
import model.DropOffAbilities.WaterwayDiscardAbility;
import model.TileSubsystem.Sector;
import model.resources.Resource;

/**
 * Created by hankerins on 4/12/17.
 */
public class ResourceManager extends ListManager<Sector, Resource> {
    @Override
    public void add(Sector l, Resource r) {
        r.setRdoAbility(new ResourceDropOffAbility(r, this));
        r.setWaterwayDiscardAbility(new WaterwayDiscardAbility());
        super.add(l, r);
    }
}
