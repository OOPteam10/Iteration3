package model.Abilities.buildAbilities;

import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LogisticalStructureBuildAbility extends LandBuildAbility {
    public abstract void execute(Sector s, SectorAdjacencyManager sam);
}
