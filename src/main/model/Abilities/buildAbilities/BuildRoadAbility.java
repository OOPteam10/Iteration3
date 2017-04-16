package model.Abilities.buildAbilities;

import model.Managers.Adjacency;
import model.Managers.SectorAdjacency;
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
    public void execute(Sector startingSector, Sector destinationSector, SectorAdjacencyManager sam, SectorAdjacencyManager roadManager) {

        CardinalDirection CD1, CD2;

        // get cardinal directions between destinationSector and startingSector
        CD1 = sam.getDirectionOfAdjacentLoc(startingSector, destinationSector);
        CD2 = CD1.getOppositeSide();

        // Tell starting sector it has a road to destination sector
        roadManager.addNewAdjacency(startingSector, CD1, destinationSector);

        // Tell destination sector it has a road to starting sector
        roadManager.addNewAdjacency(destinationSector, CD2, startingSector);

    }
}
