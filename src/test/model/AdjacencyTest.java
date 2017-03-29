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

        Map map = new Map();

        map.addTile(t1, l1);
        map.addTile(t2, l2);
        map.addTile(t3, l3);
        map.addTile(t4, l4);



        Location source = new Location(1,0,-1);
        HashMap<HexSide, Tile> adjacents = map.getAdjacentTiles(source);

        for(HexSide hs: adjacents.keySet()){
            System.out.println(hs);
        }

        assertEquals(adjacents.get(HexSide.SW), t1);
        assertEquals(adjacents.get(HexSide.NW), t2);
        assertEquals(adjacents.get(HexSide.N), t3);
        assertEquals(adjacents.get(HexSide.NE), null);
        assertEquals(adjacents.get(HexSide.SE), t4);
        assertEquals(adjacents.get(HexSide.S), null);





    }
}
