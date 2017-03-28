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

    protected ArrayList<CardinalDirection> getEdges(){
        return edges;
    }
    protected void addEdge(CardinalDirection edge){
        edges.add(edge);
    }

    public void rotate(int offset){
        for(CardinalDirection cd: edges){
            cd = cd.next();
            cd = cd.next();
        }
    }


    public int getHexagonSide(){
        return edges.get(0).getHexagonSide();
    }

    abstract protected void accept(TileVisitor v);

    public static boolean validateRiverConnection(River r1, River r2, Location relativeLoc){
        return true;
    }
}
