package model.Abilities;

import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildRoadAbility extends LogisticalStructureBuildAbility {
    private CardinalDirection CD;

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        // tell list to add build road
    }

    @Override
    public void execute(Sector s, SectorAdjacencyManager sam) {

    }
}
