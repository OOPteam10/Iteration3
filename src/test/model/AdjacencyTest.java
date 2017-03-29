package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Terrains.Rock;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by hankerins on 3/28/17.
 */
public class AdjacencyTest {
    @Test
    public void AdjacencyTest()
    {
        /*
                t3:1,1,-2
        t2:0,1,-1
                src:1,0,-1
        t1:0,0,0        t4:2,-1,-1



         */




        LandTile t1 = new LandTile(Rock.getInstance());
        Location l1 = new Location(0,0,0);
        LandTile t2 = new LandTile(Rock.getInstance());
        Location l2 = new Location(0,1,-1);
        LandTile t3 = new LandTile(Rock.getInstance());
        Location l3 = new Location(1,1,-2);
        LandTile t4 = new LandTile(Rock.getInstance());
        Location l4 = new Location(2,-1,-1);

        LandTile t5 = new LandTile(Rock.getInstance());
        Location l5 = new Location(2,0,-2);
        LandTile t6 = new LandTile(Rock.getInstance());
        Location l6 = new Location(1,-1,0);

        Map map = new Map();

        map.addLandTile(t1, l1);
        map.addLandTile(t2, l2);
        map.addLandTile(t3, l3);
        map.addLandTile(t4, l4);
        map.addLandTile(t5, l5);
        map.addLandTile(t6, l6);




        Location source = new Location(1,0,-1);
        HashMap<HexSide, Tile> adjacents = map.getAdjacentTiles(source);

        for(HexSide hs: adjacents.keySet()){
            System.out.println(hs);
            System.out.println(adjacents.get(hs).toString());
        }

        assertEquals(adjacents.get(HexSide.SW), t1);
        assertEquals(adjacents.get(HexSide.NW), t2);
        assertEquals(adjacents.get(HexSide.N), t3);
        assertEquals(adjacents.get(HexSide.NE), t5);
        assertEquals(adjacents.get(HexSide.SE), t4);
        assertEquals(adjacents.get(HexSide.S), t6);





    }
}
