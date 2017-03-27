package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;

import javax.smartcardio.Card;

/**
 * Created by hankerins on 3/26/17.
 */
public class NormalRiver extends River {
    NormalRiver(CardinalDirection edge1, CardinalDirection edge2){
        edges.add(edge1);
        edges.add(edge2);
    }
}
