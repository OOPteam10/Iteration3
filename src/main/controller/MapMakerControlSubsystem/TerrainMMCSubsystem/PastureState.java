package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Pasture;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class PastureState implements TerrainMMCSubState{
    private static PastureState instance = new PastureState();
    public static PastureState getInstance(){return instance;}
    private PastureState(){}

    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToMountain();
        }
        subContext.setSubState(MountainState.getInstance());
    }
    public void right(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToRock();
        }
        subContext.setSubState(RockState.getInstance());
    }
    public void select(MapMakerControl context){


        //just setting the terrain in TileEditor to Pasture
        TileEditor.getInstance().setTerrain(Pasture.getInstance());

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
        return "pasture";
    }
}
