package model;

import model.TileSubsystem.CardinalDirection;
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

        NormalRiver r1 = new NormalRiver(CardinalDirection.NNE, CardinalDirection.ENE);
        NormalRiver r2 = new NormalRiver(CardinalDirection.ENE, CardinalDirection.SSW);
        NormalRiver r3 = new NormalRiver(CardinalDirection.NW, CardinalDirection.SE);
        //adding edges in improper order, should be autocorrected
        NormalRiver r4 = new NormalRiver(CardinalDirection.ENE, CardinalDirection.NNE);
        //shens failing tests
        NormalRiver r5 = new NormalRiver(CardinalDirection.NNW, CardinalDirection.SW);
        NormalRiver r6 = new NormalRiver(CardinalDirection.NNW, CardinalDirection.NW);
        NormalRiver r7 = new NormalRiver(CardinalDirection.WNW, CardinalDirection.SSW);

        assertEquals(r1.getHexagonSide(), 0);
        assertEquals(r2.getHexagonSide(), 1);
        assertEquals(r3.getHexagonSide(), 5);
        assertEquals(r1.calculateAngle(), 60);
        assertEquals(r2.calculateAngle(), 120);
        assertEquals(r3.calculateAngle(), 180);
        //check for edge correction
        assertEquals(r4.getHexagonSide(), 0);
        assertEquals(r4.calculateAngle(), 60);
        assertEquals(r5.calculateAngle(), 120);
        assertEquals(r6.calculateAngle(), 30);
        assertEquals(r7.calculateAngle(), 90);


    }
}
