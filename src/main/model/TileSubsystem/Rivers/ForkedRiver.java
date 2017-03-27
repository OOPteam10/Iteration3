package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkedRiver extends River {
    public ForkedRiver(CardinalDirection edge1, CardinalDirection edge2, CardinalDirection edge3){
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
    }

    @Override
    protected void accept(TileVisitor v) {
        v.visitForkedRiver(this);
    }
}
