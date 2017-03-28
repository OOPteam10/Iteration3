package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Pasture;
import utilities.TileEditor;

/**
 * Created by rishabh on 26/03/17.
 */
public class PastureState implements TerrainMMCSubState{
    private static PastureState instance = new PastureState();
    public static PastureState getInstance(){return instance;}
    private PastureState(){}

    public void left(TerrainMMCState subContext){
        subContext.setSubState(MountainState.getInstance());
    }
    public void right(TerrainMMCState subContext){
        subContext.setSubState(RockState.getInstance());
    }
    public void select(MapMakerControl context){


        //just setting the terrain in TileEditor to Pasture
        TileEditor.getInstance().setTerrain(Pasture.getInstance());

        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "pasture";
    }
}
