package model.Transporters;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.Managers.LandTransporterManager;
import model.TileSubsystem.Sector;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class LandTransporter extends Transporter<Sector> {
    private LandTransporterDropOffAbility ltdoAbility;

    public LandTransporter(LandTransporterManager landTransporterManager){
        ltdoAbility = new LandTransporterDropOffAbility(this, landTransporterManager);
    }

    public void dropOff(Sector s){
        ltdoAbility.execute(s);
    }
}
