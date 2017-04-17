package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildNormalMineAbility extends LandProducerBuildAbility {

    public BuildNormalMineAbility(Board b0, Board b1, Board b2, Stone s) {

    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addBuildNormalMine(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }
    public String toString(){
        return "Build Mine";
    }
}
