package model.Abilities.buildAbilities;

import model.Game;
import model.ManagerSupplier;
import model.Managers.LandProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.structures.producers.primary.WoodCutter;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildWoodcutterAbility extends LandProducerBuildAbility {
    private ArrayList<Board> boardArrayList = new ArrayList<>();

    public BuildWoodcutterAbility(Board b) {
        boardArrayList.add(b);
    }

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {
        for (Board b : boardArrayList) {
            ms.getResourceManager().remove(s, b);
        }
        ms.getLandPrimaryProducerManager().add(s, new WoodCutter(ms.getResourceManager()));
    }

    public String toString(){
        return "Build Woodcutter";
    }
}
