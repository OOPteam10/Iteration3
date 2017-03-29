package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Rock;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class RockState implements TerrainMMCSubState{
    private static RockState instance = new RockState();
    public static RockState getInstance(){return instance;}
    private RockState(){}

    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToPasture();
        }
        subContext.setSubState(PastureState.getInstance());
    }
    public void right(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToSea();
        }
        subContext.setSubState(SeaState.getInstance());
    }
    public void select(MapMakerControl context){

        //just setting the terrain in TileEditor to Rock
        TileEditor.getInstance().setTerrain(Rock.getInstance());

        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).terrainSelected();
        }


        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "rock";
    }
}
