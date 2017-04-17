package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/12/17.
 */
public class BuildRaftFactoryAbility extends WaterwayAdjacentSectorBuildAbility {
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }
    public String toString(){
        return "Build Raft Factory";
    }
}
