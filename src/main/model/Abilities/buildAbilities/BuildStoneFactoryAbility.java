package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.structures.producers.secondary.refinement.StoneFactory;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildStoneFactoryAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();

    public BuildStoneFactoryAbility(Board b0, Board b1) {
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
        ms.getLandSecondaryProducerManager().add(s, new StoneFactory(ms.getResourceManager()));
    }
}
