package model;

import controller.MapMakerControlSubsystem.RiverMMCSubsystem.NoRiverState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Pasture;
import model.TileSubsystem.Tiles.RiverTile;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by hankerins on 3/27/17.
 */
public class CardinalAngleAndSideTest {



    @Test
    public void AngleAndSideTest()
    {

        NormalRiver r1 = new NormalRiver(CardinalDirection.NNE, CardinalDirection.ENE);
        NormalRiver r2 = new NormalRiver(CardinalDirection.ENE, CardinalDirection.SSW);
        NormalRiver r3 = new NormalRiver(CardinalDirection.NW, CardinalDirection.SE);

        assertEquals(r1.getHexagonSide(), 0);
        assertEquals(r2.getHexagonSide(), 1);
        assertEquals(r3.getHexagonSide(), 5);
        assertEquals(r1.getAngle(), 60);
        assertEquals(r2.getAngle(), 120);
        assertEquals(r3.getAngle(), 180);


    }
}
