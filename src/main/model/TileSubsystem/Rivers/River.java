package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 *
 */
public abstract class River {

    protected ArrayList<CardinalDirection> edges = new ArrayList<CardinalDirection>();
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
}
