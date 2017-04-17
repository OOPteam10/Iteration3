package model.Abilities.buildAbilities;

import model.ManagerSupplier;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LandBuildAbility implements BuildAbility {
    public abstract void execute(Sector s, ManagerSupplier ms);
}
