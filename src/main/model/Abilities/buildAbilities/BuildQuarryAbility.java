package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
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
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board b : boardArrayList) {
            ms.getResourceManager().remove(s, b);
        }
        ms.getLandPrimaryProducerManager().add(s, new StoneQuarry(ms.getResourceManager()));
    }
}
