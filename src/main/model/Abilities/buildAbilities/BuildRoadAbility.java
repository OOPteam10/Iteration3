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

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {
        // tell list to add build road
    }

    public BuildRoadAbility(Sector s){
        super(s);
    }

    @Override
    public void execute(Sector startingSector, SectorAdjacencyManager sam, SectorAdjacencyManager roadManager) {

        CardinalDirection CD1, CD2;

        // get cardinal directions between destinationSector and startingSector
        CD1 = sam.getDirectionOfAdjacentLoc(startingSector, getTargetSector());
        CD2 = CD1.getOppositeSide();

        // Tell starting sector it has a road to destination sector
        roadManager.addNewAdjacency(startingSector, CD1, getTargetSector());

        // Tell destination sector it has a road to starting sector
        roadManager.addNewAdjacency(getTargetSector(), CD2, startingSector);

    }

    public String toString(){
        return ("Build Road " + getTargetSector().toString());
    }
}
