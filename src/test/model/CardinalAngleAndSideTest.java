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

        assertEquals(r1.getHexagonSide(), 0);
        assertEquals(r2.getHexagonSide(), 1);
        assertEquals(r3.getHexagonSide(), 5);
        assertEquals(r1.calculateAngle(), 60);
        assertEquals(r2.calculateAngle(), 120);
        assertEquals(r3.calculateAngle(), 180);


    }
}
