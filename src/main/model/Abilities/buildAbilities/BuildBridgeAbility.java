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
    public BuildBridgeAbility(Sector s){
        super(s);
    }

    @Override
    public void execute(Sector sector1, SectorAdjacencyManager sam, SectorAdjacencyManager bam) {

    }
    public String toString(){
        return "Build Bridge";
    }
}
