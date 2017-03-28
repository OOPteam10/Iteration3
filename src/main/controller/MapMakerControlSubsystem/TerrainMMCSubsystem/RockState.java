package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Rock;
import utilities.TileEditor;

/**
 * Created by rishabh on 26/03/17.
 */
public class RockState implements TerrainMMCSubState{
    private static RockState instance = new RockState();
    public static RockState getInstance(){return instance;}
    private RockState(){}

    public void left(TerrainMMCState subContext){
        subContext.setSubState(PastureState.getInstance());
    }
    public void right(TerrainMMCState subContext){
        subContext.setSubState(SeaState.getInstance());
    }
    public void select(MapMakerControl context){

        //just setting the terrain in TileEditor to Rock
        TileEditor.getInstance().setTerrain(Rock.getInstance());

        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "rock";
    }
}
