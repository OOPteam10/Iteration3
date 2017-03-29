package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Tiles.LandTile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 3/29/17.
 */

public class CenterOfGravityTest {

    @Test
    public void centerOfGravityTest() {

        Map map = new Map();
        Location l1 = new Location(0, 0, 0);
        Location l2 = new Location(-1, 0, 1);
        Location l3 = new Location(-2, 0, 2);
        Location l4 = new Location(-2, -1, 3);
        Location l5 = new Location(-1, -1, 2);
        Location l6 = new Location(0, -1, 1);
        Location l7 = new Location(0, -2, 2);
        Location l8 = new Location(-1, -2, 3);
        Location l9 = new Location(-2, -2, 4);

        map.addLandTile(new LandTile(Mountains.getInstance()), l1);
        map.addLandTile(new LandTile(Mountains.getInstance()), l2);
        map.addLandTile(new LandTile(Mountains.getInstance()), l3);
        map.addLandTile(new LandTile(Mountains.getInstance()), l4);
        map.addLandTile(new LandTile(Mountains.getInstance()), l5);
        map.addLandTile(new LandTile(Mountains.getInstance()), l6);
        map.addLandTile(new LandTile(Mountains.getInstance()), l7);
        map.addLandTile(new LandTile(Mountains.getInstance()), l8);
        map.addLandTile(new LandTile(Mountains.getInstance()), l9);

        for(Location loc: map.getMap().keySet()){

            System.out.println(loc.toString());
        }

        System.out.println("DONE");

        map.updateCenterOfGravity();

        System.out.println("UPDATED");

        for(Location loc: map.getMap().keySet()){

            System.out.println(loc.toString());
        }

        assertNull(map.getMap().get(l9));
        assertNull(map.getMap().get(l8));
        assertNull(map.getMap().get(l7));
        assertNull(map.getMap().get(l4));
        assertNull(map.getMap().get(l3));
        assertNotNull(map.getMap().get(l1));
        assertNotNull(map.getMap().get(l2));
        assertNotNull(map.getMap().get(l5));
        assertNotNull(map.getMap().get(l6));
    }
}
