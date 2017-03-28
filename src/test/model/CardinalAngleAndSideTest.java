package model;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by hankerins on 3/27/17.
 */
public class CardinalAngleAndSideTest {



    @Test
    public void AngleAndSideTest()
    {

        NormalRiver r1 = new NormalRiver(HexSide.N, HexSide.NE);
        NormalRiver r2 = new NormalRiver(HexSide.NE, HexSide.S);
        NormalRiver r3 = new NormalRiver(HexSide.SW, HexSide.NE);
        //adding edges in improper order, should be autocorrected
        NormalRiver r4 = new NormalRiver(HexSide.NE, HexSide.N);
        NormalRiver r5 = new NormalRiver(HexSide.NE, HexSide.NW);

        assertEquals(r1.getHexagonSide(), 0);
        assertEquals(r2.getHexagonSide(), 1);
        assertEquals(r3.getHexagonSide(), 4);
        assertEquals(r1.calculateAngle(), 60);
        assertEquals(r2.calculateAngle(), 120);
        assertEquals(r3.calculateAngle(), 180);
        //check for edge correction
        assertEquals(r4.getHexagonSide(), 0);
        assertEquals(r4.calculateAngle(), 60);
        assertEquals(r5.getHexagonSide(), 5);
        assertEquals(r5.calculateAngle(), 120);

    }
}
