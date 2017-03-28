package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class NormalRiver extends River {
    public NormalRiver(CardinalDirection edge1, CardinalDirection edge2){
        addEdge(edge1);
        addEdge(edge2);
    }

    @Override
    protected void accept(TileVisitor v) {
        v.visitNormalRiver(this);
    }

    public int calculateAngle(){
        return getEdges().get(0).calculateAngle(getEdges().get(1));
    }


}
