package model.DropOffAbilities;

import model.Managers.SeaTransporterManager;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/12/17.
 */
public class SeaTransporterDropOffAbility implements DropOffAbility<Waterway> {
    SeaTransporter seaTransporter;
    SeaTransporterManager seaTransporterManager;



    public SeaTransporterDropOffAbility(SeaTransporter seaTransporter, SeaTransporterManager seaTransporterManager){
        this.seaTransporter = seaTransporter;
        this.seaTransporterManager = seaTransporterManager;
    }

    public void execute(Waterway w){
        seaTransporterManager.add(seaTransporter, w);
    }
}
