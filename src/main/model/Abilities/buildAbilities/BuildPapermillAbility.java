package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
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
        list.addBuildPaperMill(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board board : boardArrayList) {
            ms.getResourceManager().remove(s, board);
        }
        for (Stone stone : stoneArrayList) {
            ms.getResourceManager().remove(s, stone);
        }

        ms.getLandSecondaryProducerManager().add(s, new PaperMill(ms.getResourceManager()));
    }

    public String toString(){
        return "Build Papermill";
    }
}
