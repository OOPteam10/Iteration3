package model;

import model.Managers.*;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Tiles.LandTile;
import model.resources.Board;
import model.resources.Fuel;
import model.resources.Iron;
import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class NoResearchRequirementsTest {
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
        Location SMountain = new Location(0,-1,1);
        Location NEOfDesert = new Location(1, 0, -1);

        LandMap lm = map.getLandMap();

        LandTile lt1 = lm.getTile(SDesert);
        LandTile lt2 = lm.getTile(SMountain);
        LandTile lt1RoadTarget = lm.getTile(NEOfDesert);

        rm.add(lt1.getSectors().get(0), new Board());
        rm.add(lt1.getSectors().get(0), new Stone());
        System.out.println("Resources: " + rm.get(lt1.getSectors().get(0)));
        System.out.println("Structures: " + game.getLandPrimaryProducerManager().getProducer(lt1.getSectors().get(0)));
        System.out.println("Structures: " + game.getLandSecondaryProducerManager().getProducer(lt1.getSectors().get(0)));

        System.out.println("Abilities: " + rm.getLandProducerBuildAbilities(lt1.getSectors().get(0)));
        rm.getLandProducerBuildAbilities(lt1.getSectors().get(0)).get(0).execute(lt1.getSectors().get(0), game);

        System.out.println("Resources: " + rm.get(lt1.getSectors().get(0)));
        System.out.println("Structures: " + game.getLandPrimaryProducerManager().getProducer(lt1.getSectors().get(0)));
        System.out.println("Structures: " + game.getLandSecondaryProducerManager().getProducer(lt1.getSectors().get(0)));

    }
}
