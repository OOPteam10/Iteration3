package model.TileSubsystem.Rivers;

import model.TileSubsystem.HexSide;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class SourceRiver extends River {
    public SourceRiver(HexSide edge1){
        addEdge(edge1);
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitSourceRiver(this);
    }
}
