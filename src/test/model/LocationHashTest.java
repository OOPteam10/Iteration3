package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Tiles.LandTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by hankerins on 3/26/17.
 */
public class LocationHashTest {
    @Test
    public void hashTest()
    {

        Map map = new Map();
        LandTile landTile = new LandTile(Mountains.getInstance());
        Location l1 = new Location(0, 0, 0);
        Location l2 = new Location(0, 0, 0);

        map.addLandTile(landTile, l1);
        assertFalse(map.addLandTile(landTile, l2));
    }
}
