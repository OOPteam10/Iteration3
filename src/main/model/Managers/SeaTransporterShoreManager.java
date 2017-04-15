package model.Managers;

import model.DropOffAbilities.SeaTransporterDropOffAbility;
import model.TileSubsystem.Sector;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/8/17.
 */
public class SeaTransporterShoreManager extends TransporterManager<SeaTransporter, Sector> {

    @Override
    public void add(SeaTransporter o, Sector s) {
        o.setStdoAbility(new SeaTransporterDropOffAbility(o, this));
        super.add(o, s);
    }

}
