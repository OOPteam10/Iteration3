package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Tiles.SeaTile;

/**
 * Created by rishabh on 26/03/17.
 */
public class SeaState implements TerrainMMCSubState{
    private static SeaState instance = new SeaState();
    public static SeaState getInstance(){return instance;}
    private SeaState(){}

    public void left(TerrainMMCState subContext){
        subContext.setSubState(RockState.getInstance());
    }
    public void right(TerrainMMCState subContext){
        subContext.setSubState(WoodsState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setCurrentTerrain(Sea.getInstance());
        context.setTile(new SeaTile(Sea.getInstance()));
        context.addTileToMap();
    }
}
