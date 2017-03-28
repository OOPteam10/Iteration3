package model.TileSubsystem.Rivers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class NormalRiver extends River {
    public NormalRiver(HexSide edge1, HexSide edge2){
        //adds edges such that the angle is always <= 180
        if(edge1.calculateAngle(edge2) > 180){
            addEdge(edge2);
            addEdge(edge1);
        }
        else{
            addEdge(edge1);
            addEdge(edge2);
        }
    }

    @Override
    public void accept(TileVisitor v) {
        v.visitNormalRiver(this);
    }

    public int calculateAngle(){
        return getEdges().get(0).calculateAngle(getEdges().get(1));
    }


}
