package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Desert;

/**
 * Created by rishabh on 26/03/17.
 */
public class DesertState implements TerrainMMCSubState {

    private static DesertState instance = new DesertState();
    public static DesertState getInstance(){return instance;}
    private DesertState(){}

    public void left(TerrainMMCState subContext){
        subContext.setSubState(WoodsState.getInstance());
    }
    public void right(TerrainMMCState subContext){

        subContext.setSubState(MountainState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setCurrentTerrain(Desert.getInstance());
        context.setMmcState(RiverMMCState.getInstance());
    }
}
