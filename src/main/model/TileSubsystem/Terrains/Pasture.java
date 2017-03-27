package model.TileSubsystem.Terrains;

import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class Pasture extends Terrain {
    private static Pasture instance = new Pasture();
    public static Pasture getInstance(){return instance;}
    private Pasture(){}

    @Override
    public void accept(TileVisitor v) {
        v.visitPasture(this);
    }
}
