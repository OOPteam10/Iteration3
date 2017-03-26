package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkedRiver implements River {
    CardinalDirection edge1;
    CardinalDirection edge2;
    CardinalDirection edge3;
    ForkedRiver(CardinalDirection edge1, CardinalDirection edge2, CardinalDirection edge3){
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }
}
