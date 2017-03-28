package model;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Tiles.RiverTile;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by allisonaguirre on 3/27/17.
 */
public class SectorTest {
    @Test
    public void sectorTest()
    {
        ArrayList<CardinalDirection> sector1Edges = new ArrayList<CardinalDirection>();
        ArrayList<CardinalDirection> sector2Edges = new ArrayList<CardinalDirection>();
        ArrayList<CardinalDirection> sector3Edges = new ArrayList<CardinalDirection>();

        sector1Edges.add(CardinalDirection.ENE);
        sector1Edges.add(CardinalDirection.ESE);
        sector1Edges.add(CardinalDirection.SE);
        sector1Edges.add(CardinalDirection.SSE);

        sector2Edges.add(CardinalDirection.SSW);
        sector2Edges.add(CardinalDirection.SW);
        sector2Edges.add(CardinalDirection.WSW);
        sector2Edges.add(CardinalDirection.WNW);

        sector3Edges.add(CardinalDirection.NW);
        sector3Edges.add(CardinalDirection.NNW);
        sector3Edges.add(CardinalDirection.NNE);
        sector3Edges.add(CardinalDirection.NE);

        Map map = new Map();
        RiverTile landTile = new RiverTile(Mountains.getInstance(), new ForkedRiver(HexSide.NE, HexSide.S, HexSide.NW));
        Location l1 = new Location(0, 0, 0);

        map.addTile(landTile, l1);
        landTile.getSectors();

        if(landTile.getSectors().size() != 3){
            fail();
        }

        for (int i = 0; i < landTile.getSectors().size(); i++) {
            if (i == 0) {
                assertEquals(landTile.getSectors().get(i).getHalfEdges(), sector1Edges);
            } else if (i == 1) {
                assertEquals(landTile.getSectors().get(i).getHalfEdges(), sector2Edges);
            } else if (i == 2) {
                assertEquals(landTile.getSectors().get(i).getHalfEdges(), sector3Edges);
            } else {
                fail();
            }
        }
    }
}
