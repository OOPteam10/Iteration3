package model.Abilities.buildAbilities;

import model.Managers.ResourceManager;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class BuildBridgeAbility extends LogisticalStructureBuildAbility {
    private HexSide hexSide;

    @Override
    public void addToPlayerAbilityAvailabilityList(PlayerAbilityAvailability list) {

    }

    @Override
    public void execute(Sector sector1, Sector sector2, SectorAdjacencyManager sam, SectorAdjacencyManager bam) {

    }
}
