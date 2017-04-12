package model.Abilities;

import model.Managers.LandProducerOccupancyManager;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LandProducerBuildAbility extends LandBuildAbility {
    public abstract void execute(Sector s, LandProducerOccupancyManager lom);
}
