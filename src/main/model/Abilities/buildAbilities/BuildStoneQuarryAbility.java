package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.structures.producers.primary.StoneQuarry;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildStoneQuarryAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();

    public BuildStoneQuarryAbility(Board b0, Board b1) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addBuildStoneQuarry(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board b : boardArrayList) {
            ms.getResourceManager().remove(s, b);
        }
        ms.getLandPrimaryProducerManager().add(s, new StoneQuarry(ms.getResourceManager()));
    }
    public String toString(){
        return "Build Quarry";
    }
}
