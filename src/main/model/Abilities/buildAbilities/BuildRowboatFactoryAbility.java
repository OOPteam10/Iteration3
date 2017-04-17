package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/12/17.
 */
public class BuildRowboatFactoryAbility extends WaterwayAdjacentSectorBuildAbility {
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }
    public String toString(){
        return "Build Rowboat Factory";
    }
}
