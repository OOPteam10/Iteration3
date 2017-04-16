package model.Abilities.buildAbilities;

import model.Game;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.structures.producers.primary.StoneQuarry;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildQuarryAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();

    public BuildQuarryAbility(Board b0, Board b1) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, Game game) {
        for (Board b : boardArrayList) {
            game.getResourceManager().remove(s, b);
        }
        game.getLandPrimaryProducerManager().add(s, new StoneQuarry(game.getResourceManager()));
    }
}
