package model.TileSubsystem.Terrains;

/**
 * Created by hankerins on 3/26/17.
 */
public class Desert extends Terrain {
    private static Desert instance = new Desert();
    public static Desert getInstance(){return instance;}
    private Desert(){}
}
