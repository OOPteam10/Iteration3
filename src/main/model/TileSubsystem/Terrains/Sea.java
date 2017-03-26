package model.TileSubsystem.Terrains;

/**
 * Created by hankerins on 3/26/17.
 */
public class Sea extends Terrain {
    private static Sea instance = new Sea();
    public static Sea getInstance(){return instance;}
    private Sea(){}
}
