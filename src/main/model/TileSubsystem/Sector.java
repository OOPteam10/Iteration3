package model.TileSubsystem;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class Sector {
    ArrayList<CardinalDirection> halfEdges = new ArrayList<CardinalDirection>();
    public Sector(CardinalDirection start, CardinalDirection finish){
        halfEdges.add(start);
        while (start != finish){
            start = start.next();
            halfEdges.add(start);
        }
    }

    public boolean contains(CardinalDirection cd){
        return halfEdges.contains(cd);
    }

    public ArrayList<CardinalDirection> getHalfEdges() {
        return halfEdges;
    }
}
