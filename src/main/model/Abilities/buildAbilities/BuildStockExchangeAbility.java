package model.Abilities.buildAbilities;

import model.Game;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Stone;
import model.structures.producers.secondary.refinement.StockExchange;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildStockExchangeAbility extends LandProducerBuildAbility {
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildStockExchangeAbility(Stone s0, Stone s1, Stone s2) {
        stoneArrayList.add(s0);
        stoneArrayList.add(s1);
        stoneArrayList.add(s2);
    }
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, Game game) {
        for (Stone stone : stoneArrayList) {
            game.getResourceManager().remove(s, stone);
        }
        game.getLandSecondaryProducerManager().add(s, new StockExchange(game.getResourceManager()));
    }
}
