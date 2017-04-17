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

    public BuildWallAbility(Sector s){
        super(s);
    }

    @Override
    public void execute(Sector startingSector, SectorAdjacencyManager sam, SectorAdjacencyManager bridgeManager) {

    }
}
