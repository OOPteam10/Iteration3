package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkedRiver extends River {
    ForkedRiver(CardinalDirection edge1, CardinalDirection edge2, CardinalDirection edge3){
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
    }
}
