package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.Managers.SeaProducerManager;
import model.TileSubsystem.Tiles.SeaTile;
import model.resources.Board;
import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildOilRigAbility extends SeaBuildAbility {
    public BuildOilRigAbility(Board b0, Board b1, Board b2, Stone s) {

    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(SeaTile s, SeaProducerManager spm) {

    }
    public String toString(){
        return "Build Oil Rig";
    }
}
