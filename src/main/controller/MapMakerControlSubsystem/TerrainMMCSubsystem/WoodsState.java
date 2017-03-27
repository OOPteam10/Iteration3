package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Desert;
import model.TileSubsystem.Terrains.Woods;

/**
 * Created by rishabh on 26/03/17.
 */
public class WoodsState implements TerrainMMCSubState{
    private static WoodsState instance = new WoodsState();
    public static WoodsState getInstance(){return instance;}
    private WoodsState(){}

    public void left(TerrainMMCState subContext){
        subContext.setSubState(SeaState.getInstance());
    }
    public void right(TerrainMMCState subContext){
        subContext.setSubState(DesertState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setCurrentTerrain(Woods.getInstance());
        context.setMmcState(RiverMMCState.getInstance());
    }
}
