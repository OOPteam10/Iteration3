package model.TileSubsystem.Terrains;

import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class Mountains extends Terrain {
    private static Mountains instance = new Mountains();
    public static Mountains getInstance(){return instance;}
    private Mountains(){}

    @Override
    public void accept(TileVisitor v) {
        v.visitMountains(this);
    }
}
