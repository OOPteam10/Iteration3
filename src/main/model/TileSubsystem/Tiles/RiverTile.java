package model.TileSubsystem.Tiles;

import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Terrain;

/**
 * Created by hankerins on 3/26/17.
 */
public class RiverTile extends LandTile {

    River river;

    public RiverTile(Terrain terrain, River river){
        super(terrain);
        this.river = river;
    }
}
