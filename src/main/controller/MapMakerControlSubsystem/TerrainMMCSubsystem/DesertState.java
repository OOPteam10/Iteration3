package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Desert;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class DesertState implements TerrainMMCSubState {

    private static DesertState instance = new DesertState();
    public static DesertState getInstance(){return instance;}
    private DesertState(){}

    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToWoods();
        }
        subContext.setSubState(WoodsState.getInstance());
    }
    public void right(TerrainMMCState subContext, Vector<MMCObserver> mmcObservers){


        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToMountain();
        }
        subContext.setSubState(MountainState.getInstance());
    }
    public void select(MapMakerControl context){


        //just setting the terrain in TileEditor to Desert
        TileEditor.getInstance().setTerrain(Desert.getInstance());
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).terrainSelected();
        }
        //make next transiton of state machine
        context.setMmcState(RiverMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "desert";
    }
}
