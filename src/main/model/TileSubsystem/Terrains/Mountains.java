package model.TileSubsystem.Terrains;

/**
 * Created by hankerins on 3/26/17.
 */
public class Mountains extends Terrain {
    private static Mountains instance = new Mountains();
    public static Mountains getInstance(){return instance;}
    private Mountains(){}
}
