package model.Managers;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/8/17.
 */
public class LandTransporterManager extends SectorTransporterManager<LandTransporter> {

    @Override
    public void add(LandTransporter o, Sector sector) {
        o.setLtdoAbility(new LandTransporterDropOffAbility(o, this));
        super.add(o, sector);
    }
}
