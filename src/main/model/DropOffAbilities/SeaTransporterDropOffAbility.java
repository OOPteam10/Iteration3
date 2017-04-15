package model.DropOffAbilities;

import model.Managers.SeaTransporterManager;
import model.Managers.SeaTransporterShoreManager;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/12/17.
 */
public class SeaTransporterDropOffAbility implements DropOffAbility<Sector> {
    SeaTransporter seaTransporter;
    SeaTransporterShoreManager seaTransporterShoreManager;



    public SeaTransporterDropOffAbility(SeaTransporter seaTransporter, SeaTransporterShoreManager seaTransporterShoreManager){
        this.seaTransporter = seaTransporter;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
    }

    public void execute(Sector s){
        seaTransporterShoreManager.add(seaTransporter, s);
    }
}
