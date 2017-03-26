package model.TileSubsystem.Terrains;

/**
 * Created by hankerins on 3/26/17.
 */
public class Woods extends Terrain {
    private static Woods instance = new Woods();
    public static Woods getInstance(){return instance;}
    private Woods(){}
}
