package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Tiles.RiverTile;
import org.junit.Test;

/**
 * Created by allisonaguirre on 3/27/17.
 */
public class SectorTest {
    @Test
    public void sectorTest()
    {

        Map map = new Map();
        RiverTile landTile = new RiverTile(Mountains.getInstance(), new NormalRiver(CardinalDirection.NNE, CardinalDirection.SSW));
        Location l1 = new Location(0, 0, 0);

        map.addTile(landTile, l1);
//        assertFalse(map.addTile(landTile, l2));
    }
}
