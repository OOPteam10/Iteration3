package model.TileSubsystem.Terrains;

import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class Desert extends Terrain {
    private static Desert instance = new Desert();
    public static Desert getInstance(){return instance;}
    private Desert(){}

    @Override
    public void accept(TileVisitor v) {
        v.visitDesert(this);
    }

    //testing only
    public String toString(){
        return "Desert";
    }
}
