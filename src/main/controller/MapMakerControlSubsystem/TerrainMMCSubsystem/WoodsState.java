package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Woods;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class WoodsState implements TerrainMMCSubState{
    private static WoodsState instance = new WoodsState();
    public static WoodsState getInstance(){return instance;}
    private WoodsState(){}

    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i=0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToSea();
        }
        subContext.setSubState(SeaState.getInstance());
    }
    public void right(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){

        for(int i=0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToDesert();
        }
        subContext.setSubState(DesertState.getInstance());
    }
    public void select(MapMakerControl context){

        //just setting the terrain in TileEditor to Woods
        TileEditor.getInstance().setTerrain(Woods.getInstance());

        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).terrainSelected();
        }

        //make next transition to River selection state, of state machine
        context.setMmcState(RiverMMCState.getInstance());


    }
    //for testing
    public String toString(){
        return "woods";
    }
}
