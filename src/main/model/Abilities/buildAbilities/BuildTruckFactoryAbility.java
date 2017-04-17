package model.Abilities.buildAbilities;

import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.ManagerSupplier;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildTruckFactoryAbility extends LandProducerBuildAbility {
    public BuildTruckFactoryAbility(Board b0, Board b1, Stone s0, Stone s1) {

    }
    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        list.addTruckFactory(this);
    }

    @Override
    public void execute(Sector s, ManagerSupplier ms) {

    }

    public String toString(){
        return "Build Truck Factory";
    }
}
