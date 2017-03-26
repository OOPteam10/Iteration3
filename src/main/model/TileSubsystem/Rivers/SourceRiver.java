package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;

/**
 * Created by hankerins on 3/26/17.
 */
public class SourceRiver implements River {
    CardinalDirection start;
    SourceRiver(CardinalDirection start){
        this.start = start;
    }
}
