package model.TileSubsystem.Terrains;

import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class Sea extends Terrain {
    private static Sea instance = new Sea();
    public static Sea getInstance(){return instance;}
    private Sea(){}

    @Override
    protected void accept(TileVisitor v) {
        v.visitSea(this);
    }
}
