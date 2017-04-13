package model.DropOffAbilities;

import model.Managers.LandTransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/12/17.
 */
public class LandTransporterDropOffAbility implements DropOffAbility<Sector> {
    LandTransporter landTransporter;
    LandTransporterManager landTransporterManager;



    public LandTransporterDropOffAbility(LandTransporter landTransporter, LandTransporterManager landTransporterManager){
        this.landTransporter = landTransporter;
        this.landTransporterManager = landTransporterManager;
    }

    public void execute(Sector s){
        landTransporterManager.add(landTransporter, s);
    }
}
