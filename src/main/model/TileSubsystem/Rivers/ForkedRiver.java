package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkedRiver extends River {
    public ForkedRiver(HexSide edge1, HexSide edge2, HexSide edge3){
        addEdge(edge1);
        addEdge(edge2);
        addEdge(edge3);
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitForkedRiver(this);
    }
}
