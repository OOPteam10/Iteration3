package model.TileSubsystem.Terrains;

import model.TileSubsystem.Visitor.TileVisitor;

/**
 * Created by hankerins on 3/26/17.
 */
public class Woods extends Terrain {
    private static Woods instance = new Woods();
    public static Woods getInstance(){return instance;}
    private Woods(){}

    @Override
    public void accept(TileVisitor v) {
        v.visitWoods(this);
    }
}
