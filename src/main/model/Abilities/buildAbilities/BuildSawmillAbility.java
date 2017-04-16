package model.Abilities.buildAbilities;

import model.Game;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
import model.structures.producers.secondary.refinement.SawMill;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildSawmillAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildSawmillAbility(Board b0, Board b1, Stone s) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        stoneArrayList.add(s);
    }
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, Game game) {
        for (Board b : boardArrayList) {
            game.getResourceManager().remove(s, b);
        }

        for (Stone stone : stoneArrayList) {
            game.getResourceManager().remove(s, stone);
        }
        game.getLandSecondaryProducerManager().add(s, new SawMill(game.getResourceManager()));
    }
}
