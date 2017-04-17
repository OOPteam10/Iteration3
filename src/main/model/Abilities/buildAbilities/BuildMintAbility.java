package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;
import model.structures.producers.secondary.refinement.Mint;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildMintAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();

    public BuildMintAbility(Board b0, Board b1, Stone s) {
        boardArrayList.add(b0);
        boardArrayList.add(b1);
        stoneArrayList.add(s);
    }
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addBuildMint(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board board : boardArrayList) {
            ms.getResourceManager().remove(s, board);
        }

        ms.getLandSecondaryProducerManager().add(s, new Mint(ms.getResourceManager()));
    }
    public String toString(){
        return "Build Mint";
    }
}
