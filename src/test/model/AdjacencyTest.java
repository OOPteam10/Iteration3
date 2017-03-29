package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Terrains.Rock;
import model.TileSubsystem.Tiles.LandTile;
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

        LandTile t1 = new LandTile(Rock.getInstance());
        Location l1 = new Location(0,0,0);
        LandTile t2 = new LandTile(Rock.getInstance());
        Location l2 = new Location(0,1,-1);
        LandTile t3 = new LandTile(Rock.getInstance());
        Location l3 = new Location(1,1,-2);
        LandTile t4 = new LandTile(Rock.getInstance());
        Location l4 = new Location(2,-1,-1);

        Map map = new Map();

        Location source = new Location(1,0,-1);
        HashMap<HexSide, Location> adjacents ;





    }
}
