package model.TileSubsystem.Rivers;

import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 *
 */
public abstract class River {
    private ArrayList<CardinalDirection> edges = new ArrayList<CardinalDirection>();

    public void rotate(int offset){
        for(CardinalDirection cd: edges){
            cd = cd.next();
            cd = cd.next();
        }
    }

    public int getHexagonSide() {
        return edges.get(0).getHexagonSide();
    }

    public ArrayList<CardinalDirection> getEdges() {
        return edges;
    }

    public void addEdge(CardinalDirection edge) {
        edges.add(edge);
    }

    abstract protected void accept(TileVisitor v);

    public static boolean validateRiverConnection(River r1, River r2, Location relativeLoc){
        return true;
    }
}
