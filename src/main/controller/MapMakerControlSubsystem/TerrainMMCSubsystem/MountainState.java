package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Terrains.Pasture;

/**
 * Created by rishabh on 26/03/17.
 */
public class MountainState implements TerrainMMCSubState{
    private static MountainState instance = new MountainState();
    public static MountainState getInstance(){return instance;}
    private MountainState(){}


    public void left(TerrainMMCState subContext){
        subContext.setSubState(DesertState.getInstance());
    }
    public void right(TerrainMMCState subContext){
        subContext.setSubState(PastureState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setCurrentTerrain(Mountains.getInstance());
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "mountain";
    }
}
