package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;

import javax.smartcardio.Card;

/**
 * Created by hankerins on 3/26/17.
 */
public class NormalRiver implements River {
    CardinalDirection start;
    CardinalDirection finish;
    NormalRiver(CardinalDirection start, CardinalDirection finish){
        this.start = start;
        this.finish = finish;
    }
}
