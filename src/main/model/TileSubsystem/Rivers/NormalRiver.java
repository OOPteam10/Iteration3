package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Visitor.TileVisitor;

import javax.smartcardio.Card;

/**
 * Created by hankerins on 3/26/17.
 */
public class NormalRiver extends River {
    public NormalRiver(CardinalDirection edge1, CardinalDirection edge2){
        edges.add(edge1);
        edges.add(edge2);
    }

    @Override
    protected void accept(TileVisitor v) {
        v.visitNormalRiver(this);
    }

    public int getAngle(){
        return edges.get(0).angle(edges.get(1));
    }


}
