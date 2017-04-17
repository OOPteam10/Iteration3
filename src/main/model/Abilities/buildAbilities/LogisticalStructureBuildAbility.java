package model.Abilities.buildAbilities;

import model.ManagerSupplier;
import model.Managers.ResourceManager;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LogisticalStructureBuildAbility extends LandBuildAbility {
    private Sector targetSector;

    public Sector getTargetSector(){
        return targetSector;
    }
    public LogisticalStructureBuildAbility(Sector s){
        this.targetSector = s;
    }

    public void execute(Sector s, ManagerSupplier ms){
        execute(s, ms.getSectorAdjacencyManager(), ms.getRoadAdjacencyManager());
    }

    public abstract void execute(Sector s, SectorAdjacencyManager sam, SectorAdjacencyManager managerToAddTo);
}
