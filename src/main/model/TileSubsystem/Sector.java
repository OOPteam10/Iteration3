package model.TileSubsystem;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class Sector {
    ArrayList<CardinalDirection> halfEdges;
    Sector(CardinalDirection start, CardinalDirection finish){
        halfEdges.add(start);
        while (start != finish){
            start = start.next();
            halfEdges.add(start);
        }
    }
}
