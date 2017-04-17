package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildGoldSpecializedMineAbility extends LandProducerBuildAbility {
    ArrayList<Board> boardArrayList = new ArrayList<>();
    ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildGoldSpecializedMineAbility(Board b0, Board b1, Board b2, Stone s) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        boardArrayList.add(b2);
        stoneArrayList.add(s);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addGoldSpecializedMine(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        // TODO
    }
}
