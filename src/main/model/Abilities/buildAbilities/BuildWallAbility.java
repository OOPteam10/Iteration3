package model.Abilities.buildAbilities;

import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildWallAbility extends LogisticalStructureBuildAbility {
    private HexSide hexSide;

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector startingSector, Sector destinationSector, SectorAdjacencyManager sam, SectorAdjacencyManager bridgeManager) {

    }
}
