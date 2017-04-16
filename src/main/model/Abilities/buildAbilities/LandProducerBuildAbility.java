package model.Abilities.buildAbilities;

import model.Managers.LandProducerManager;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LandProducerBuildAbility extends LandBuildAbility {
    public abstract void execute(Sector s, LandProducerManager lom);
}
