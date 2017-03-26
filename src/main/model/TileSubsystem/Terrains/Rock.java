package model.TileSubsystem.Terrains;

/**
 * Created by hankerins on 3/26/17.
 */
public class Rock extends Terrain {
    private static Rock instance = new Rock();
    public static Rock getInstance(){return instance;}
    private Rock(){}
}
