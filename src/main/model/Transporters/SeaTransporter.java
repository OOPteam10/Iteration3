package model.Transporters;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.DropOffAbilities.SeaTransporterDropOffAbility;
import model.Managers.LandTransporterManager;
import model.Managers.SeaTransporterManager;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;

/**
 * Created by hankerins on 4/8/17.
 */
public  abstract class SeaTransporter extends Transporter<Waterway> {
    private SeaTransporterDropOffAbility stdoAbility;

    public SeaTransporter(SeaTransporterManager seaTransporterManager){
        stdoAbility = new SeaTransporterDropOffAbility(this, seaTransporterManager);
    }

    public void dropOff(Waterway w){
        stdoAbility.execute(w);
    }


}
