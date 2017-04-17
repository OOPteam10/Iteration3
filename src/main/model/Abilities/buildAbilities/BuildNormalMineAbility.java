package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
import model.structures.producers.primary.mine.NormalMine;
import model.structures.producers.secondary.refinement.Mint;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildNormalMineAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildNormalMineAbility(Board b0, Board b1, Board b2, Stone s) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        boardArrayList.add(b2);
        stoneArrayList.add(s);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addBuildNormalMine(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board board : boardArrayList) {
            ms.getResourceManager().remove(s, board);
        }

        for (Stone stone : stoneArrayList) {
            ms.getResourceManager().remove(s, stone);
        }
        ms.getLandPrimaryProducerManager().add(s, new NormalMine(ms.getResourceManager()));
    }
    public String toString(){
        return "Build Mine";
    }
}
