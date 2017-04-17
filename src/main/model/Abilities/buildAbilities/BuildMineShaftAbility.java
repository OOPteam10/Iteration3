package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Fuel;
import model.resources.Iron;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildMineShaftAbility extends LandProducerBuildAbility {
    public BuildMineShaftAbility(Iron i, Fuel f) {

    }
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }
    public String toString(){
        return "Build Mine Shaft";
    }
}
