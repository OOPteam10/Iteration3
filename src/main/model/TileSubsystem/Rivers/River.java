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

    public void rotateR(){
        ArrayList<HexSide> newEdges = new ArrayList<HexSide>();
        for(HexSide side: edges){
            newEdges.add(side.next());

        }
        this.edges = newEdges;
    }
    public void rotateL(){
        ArrayList<HexSide> newEdges = new ArrayList<HexSide>();
        for(HexSide side: edges){
            newEdges.add(side.previous());
        }
        this.edges = newEdges;
    }

    public int getHexagonSide() {
        return edges.get(0).ordinal();
    }

    abstract public void accept(TileVisitor v);

    public static boolean validateRiverConnection(River source, River target, HexSide adjacency){
        boolean sourceAdjacencyHasRiver = false;
        boolean targetAdjacencyHasRiver = false;
        for(HexSide hs: source.getEdges()) {
            if (hs == adjacency) {
                sourceAdjacencyHasRiver = true;
            }
        }
        for(HexSide hs: target.getEdges()) {
            if (hs == adjacency.getOppositeSide()) {
                targetAdjacencyHasRiver = true;
            }
        }
        return (sourceAdjacencyHasRiver == targetAdjacencyHasRiver);
    }
    public static boolean validateRiverToLandConnection(River source, HexSide adjacency){
        boolean sourceAdjacencyHasRiver = false;
        for(HexSide hs: source.getEdges()) {
            if (hs == adjacency) {
                sourceAdjacencyHasRiver = true;
            }
        }
        return !sourceAdjacencyHasRiver;
    }

    public static boolean validateLandToRiverConnection(River target, HexSide adjacency){
        boolean sourceAdjacencyHasNoRiver = true;
        for(HexSide hs: target.getEdges()) {
            if (hs == adjacency.getOppositeSide()) {
                sourceAdjacencyHasNoRiver = false;
            }
        }
        return sourceAdjacencyHasNoRiver;
    }
}
