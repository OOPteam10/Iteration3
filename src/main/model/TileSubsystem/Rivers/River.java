package model.TileSubsystem.Rivers;

import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 *
 */
public abstract class River {


    private ArrayList<HexSide> edges = new ArrayList<HexSide>();

    public ArrayList<HexSide> getEdges(){
        return edges;
    }
    protected void addEdge(HexSide edge){
        edges.add(edge);
    }

    public void rotate(int offset){
        for(HexSide side: edges){
            side = side.next();
        }
    }

    public int getHexagonSide() {
        return edges.get(0).ordinal();
    }
    
    abstract public void accept(TileVisitor v);

    public static boolean validateRiverConnection(River source, River target, Location relativeLoc){
        return true;
    }
}
