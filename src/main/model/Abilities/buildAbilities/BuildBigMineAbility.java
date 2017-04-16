package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildBigMineAbility extends LandProducerBuildAbility {
    ArrayList<Board> boardArrayList = new ArrayList<>();
    ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildBigMineAbility(Board b0, Board b1, Board b2, Stone s) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        boardArrayList.add(b2);
        stoneArrayList.add(s);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }
}
