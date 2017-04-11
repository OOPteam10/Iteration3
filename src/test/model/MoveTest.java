package model;

import model.Managers.*;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Waterway;
import model.Transporters.Donkey;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hankerins on 4/10/17.
 */
public class MoveTest {
    @Test
    public void MoveTest()
    {

        Game game = new Game();
        game.setDefaultMap();
        Map map = game.getActualMap();
        map.formatSurfaceMaps();
        LandMap lm = map.getLandMap();
        WaterwayMap wm = map.getWaterwayMap();

        SectorAdjacencyManager sam = map.generateSectorAdjacencyManager();
        WaterwayAdjacencyManager wam = map.generateWaterwayAdjacencyManager();

        LandTransporterManager landTransporterManager = new LandTransporterManager();



        //System.out.println(wm.toString());
        //WaterwayMap is created correctly

       // System.out.println(wam.toString());

        Location SDesert = new Location(0,0,0);
        Location SMountain = new Location(0,-1,1);
        Location CENTERSea = new Location(0, 1, -1);

        LandTile lt1 = lm.getTile(SDesert);
        Waterway w1 = wm.getTile(SDesert);
        LandTile lt2 = lm.getTile(SMountain);
        Waterway w2 = wm.getTile(SMountain);
        Waterway w3 = wm.getTile(CENTERSea);


        Donkey badonk = new Donkey();

        landTransporterManager.add(badonk, lt1.getSectorAtCardinalDirection(CardinalDirection.NE));

        Sector findDonkey = landTransporterManager.getLocation(badonk);

        Adjacency<CardinalDirection, Sector> donkeysPossibleMovements = sam.getAdjacency(findDonkey);

        System.out.println(donkeysPossibleMovements.toString());

        Sector target = donkeysPossibleMovements.getAdjacent(CardinalDirection.NW);

        landTransporterManager.move(badonk, target);

        findDonkey = landTransporterManager.getLocation(badonk);

        System.out.print(findDonkey.toString());




        assertEquals(lt1, w1);
        assertEquals(lt2, w2);

    }
}
