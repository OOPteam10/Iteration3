package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
import model.structures.producers.primary.ClayPit;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/12/17.
 */
public class BuildClayPitAbility extends WaterwayAdjacentSectorBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();

    public BuildClayPitAbility(Board b0, Board b1, Board b2) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        boardArrayList.add(b2);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board board : boardArrayList) {
            ms.getResourceManager().remove(s, board);
        }
        ms.getLandPrimaryProducerManager().add(s, new ClayPit(ms.getResourceManager()));
    }
}
