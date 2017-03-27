package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class SourceRiver extends River {
    public SourceRiver(CardinalDirection edge1){
        edges.add(edge1);
    }

    @Override
    protected void accept(TileVisitor v) {
        v.visitSourceRiver(this);
    }
}
