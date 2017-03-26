package model.TileSubsystem;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class Sector {
    ArrayList<CardinalDirection> halfEdges;
    Sector(CardinalDirection start, CardinalDirection finish){
        for(int i = start.ordinal(); i <= finish.ordinal(); i++){
            halfEdges.add(CardinalDirection.values()[i]);
        }
    }
}
