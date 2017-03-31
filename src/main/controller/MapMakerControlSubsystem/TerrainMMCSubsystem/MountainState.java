package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Terrains.Pasture;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class MountainState implements TerrainMMCSubState{
    private static MountainState instance = new MountainState();
    public static MountainState getInstance(){return instance;}
    private MountainState(){}


    public void left(TerrainMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToDesert();
        }

        subContext.setSubState(DesertState.getInstance());

    }
    public void right(TerrainMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToPasture();
        }

        subContext.setSubState(PastureState.getInstance());
    }
    public void select(MapMakerControl context){

        //just setting the terrain in TileEditor to Mountains
        TileEditor.getInstance().setTerrain(Mountains.getInstance());

        //notifying the observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).terrainSelected();
        }

        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "mountain";
    }
}
