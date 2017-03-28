package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Desert;
import utilities.TileEditor;

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


        //just setting the terrain in TileEditor to Desert
        TileEditor.getInstance().setTerrain(Desert.getInstance());

        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "desert";
    }
}
