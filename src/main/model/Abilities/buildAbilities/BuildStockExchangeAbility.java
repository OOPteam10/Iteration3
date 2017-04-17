package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
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
        list.addBuildStockExchange(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Stone stone : stoneArrayList) {
            ms.getResourceManager().remove(s, stone);
        }
        ms.getLandSecondaryProducerManager().add(s, new StockExchange(ms.getResourceManager()));
    }
    public String toString(){
        return "Build Stock Exchange";
    }
}
