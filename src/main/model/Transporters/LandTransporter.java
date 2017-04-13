package model.Transporters;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.Managers.LandTransporterManager;
import model.TileSubsystem.Sector;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class LandTransporter extends Transporter<Sector> {
    private LandTransporterDropOffAbility ltdoAbility;

    public void setLtdoAbility(LandTransporterDropOffAbility ltdoAbility){
        this.ltdoAbility = ltdoAbility;
    }

    public void dropOff(Sector s){
        ltdoAbility.execute(s);
    }
}
