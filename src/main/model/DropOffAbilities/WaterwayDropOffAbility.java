package model.DropOffAbilities;

import model.Managers.SeaTransporterManager;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/15/17.
 */
public class WaterwayDropOffAbility implements DropOffAbility<Waterway>{
    SeaTransporter seaTransporter;
    SeaTransporterManager seaTransporterManager;



    public WaterwayDropOffAbility(SeaTransporter seaTransporter, SeaTransporterManager seaTransporterManager){
        this.seaTransporter = seaTransporter;
        this.seaTransporterManager = seaTransporterManager;
    }

    public void execute(Waterway w){
        seaTransporterManager.add(seaTransporter, w);
    }
}
