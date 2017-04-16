package model.Abilities.buildAbilities;

import model.Game;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
import model.structures.producers.secondary.refinement.Mint;
import model.structures.producers.secondary.refinement.PaperMill;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildPapermillAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildPapermillAbility(Board b, Stone s) {
        boardArrayList.add(b);
        stoneArrayList.add(s);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, Game game) {
        for (Board board : boardArrayList) {
            game.getResourceManager().remove(s, board);
        }
        for (Stone stone : stoneArrayList) {
            game.getResourceManager().remove(s, stone);
        }

        game.getLandSecondaryProducerManager().add(s, new PaperMill(game.getResourceManager()));
    }
}
