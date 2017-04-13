package model.Managers;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.DropOffAbilities.SeaTransporterDropOffAbility;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/8/17.
 */
public class SeaTransporterManager extends TransporterManager<SeaTransporter, Waterway> {

    @Override
    public void add(SeaTransporter o, Waterway waterway) {
        o.setStdoAbility(new SeaTransporterDropOffAbility(o, this));
        super.add(o, waterway);
    }
}
