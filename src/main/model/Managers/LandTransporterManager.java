package model.Managers;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public class LandTransporterManager extends TransporterManager<LandTransporter, Sector> {

    @Override
    public void add(LandTransporter o, Sector sector) {
        o.setLtdoAbility(new LandTransporterDropOffAbility(o, this));
        super.add(o, sector);
    }
}
