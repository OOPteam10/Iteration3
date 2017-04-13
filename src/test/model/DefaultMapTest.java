package model;

import model.Managers.Adjacency;
import model.Managers.SectorAdjacency;
import model.Managers.SectorAdjacencyManager;
import model.Managers.WaterwayAdjacencyManager;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Waterway;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hankerins on 4/10/17.
 */
public class DefaultMapTest {
    @Test
    public void DefaultTest()
    {

        Game game = new Game();
        game.setDefaultMap();
        Map map = game.getActualMap();
        map.formatSurfaceMaps();
        LandMap lm = map.getLandMap();
        WaterwayMap wm = map.getWaterwayMap();

        SectorAdjacencyManager sam = game.getSectorAdjacencyManager();
        WaterwayAdjacencyManager wam = game.getWaterwayAdjacencyManager();

        //System.out.println(wm.toString());
        //WaterwayMap is created correctly

        System.out.println(wam.toString());

        Location SDesert = new Location(0,0,0);
        Location SMountain = new Location(0,-1,1);
        Location CENTERSea = new Location(0, 1, -1);

        LandTile lt1 = lm.getTile(SDesert);
        Waterway w1 = wm.getTile(SDesert);
        LandTile lt2 = lm.getTile(SMountain);
        Waterway w2 = wm.getTile(SMountain);
        Waterway w3 = wm.getTile(CENTERSea);

        assertEquals(lt1, w1);
        assertEquals(lt2, w2);


        Adjacency<CardinalDirection, Sector> sa1lt1 = sam.getAdjacency(lt1.getSectors().get(0));
        Adjacency<CardinalDirection, Sector> sa2lt1 = sam.getAdjacency(lt1.getSectors().get(1));

        assertEquals(sa1lt1.getAdjacent(CardinalDirection.NW), lm.getTile(new Location(-1, 1, 0)).getSectorAtCardinalDirection(CardinalDirection.ESE));
        assertEquals(sa1lt1.getAdjacent(CardinalDirection.NE), lm.getTile(new Location(1, 0, -1)).getSectorAtCardinalDirection(CardinalDirection.WSW));

        Adjacency<HexSide, Waterway> wa1 = wam.getAdjacency(w1);
        Adjacency<HexSide, Waterway> wa2 = wam.getAdjacency(w2);

        System.out.println(sa1lt1.toString());
        System.out.println(sa2lt1.toString());

        System.out.println(w1.toString());
        System.out.println(wa1.toString());
        System.out.println(w2.toString());
        System.out.println(wa2.toString());

        assertEquals(wa2.getAdjacent(HexSide.NW), wm.getTile(new Location(-1, 0, 1)));
        assertEquals(wa1.getAdjacent(HexSide.NW), wm.getTile(new Location(-1, 1, 0)));


        for(Sector s: lt2.getSectors()){
            System.out.println(s.toString());
        }





    }
}
