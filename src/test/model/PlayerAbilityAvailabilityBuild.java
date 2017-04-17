package model;

import model.Abilities.buildAbilities.BuildIronSpecializedMineAbility;
import model.Abilities.playerAbilityAvailability.BuildBigMineAbilityAvailability;
import model.Abilities.playerAbilityAvailability.BuildGoldSpecializedMineAbilityAvailability;
import model.Abilities.playerAbilityAvailability.BuildIronSpecializedMineAbilityAvailability;
import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.Managers.*;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.LandTile;
import model.resources.Board;
import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class PlayerAbilityAvailabilityBuild {
    public static void main(String args[]){
        Game game = new Game();
        Map map = game.getActualMap();

        SectorAdjacencyManager sam = game.getSectorAdjacencyManager();
        WaterwayAdjacencyManager wam = game.getWaterwayAdjacencyManager();
        LandTransporterManager ltm = game.getLandTransporterManager();
        SeaTransporterManager stm = game.getSeaTransporterManager();
        SeaTransporterShoreManager stsm = game.getSeaTransporterShoreManager();
        game.getLandPrimaryProducerManager();
        ResourceManager rm = game.getResourceManager();

        Location SDesert = new Location(0,0,0);

        LandMap lm = map.getLandMap();

        LandTile lt1 = lm.getTile(SDesert);

        PlayerAbilityAvailability p = new PlayerAbilityAvailability();

        rm.add(lt1.getSectors().get(0), new Board());
        rm.add(lt1.getSectors().get(0), new Board());
        rm.add(lt1.getSectors().get(0), new Board());
        rm.add(lt1.getSectors().get(0), new Stone());
        System.out.println("Resources: " + rm.get(lt1.getSectors().get(0)));
        System.out.println("Abilities: " + rm.getLandProducerBuildAbilities(lt1.getSectors().get(0), p));

        BuildBigMineAbilityAvailability bbb = new BuildBigMineAbilityAvailability(p);
        System.out.println("Abilities with big mine: " + rm.getLandProducerBuildAbilities(lt1.getSectors().get(0), bbb));

        BuildIronSpecializedMineAbilityAvailability ism = new BuildIronSpecializedMineAbilityAvailability(bbb);
        System.out.println("Abilities with big mine + Iron Mine: " + rm.getLandProducerBuildAbilities(lt1.getSectors().get(0), ism));

        BuildGoldSpecializedMineAbilityAvailability gsm = new BuildGoldSpecializedMineAbilityAvailability(ism);
        System.out.println("Abilities with big mine + Iron Mine: " + rm.getLandProducerBuildAbilities(lt1.getSectors().get(0), gsm));
    }
}
