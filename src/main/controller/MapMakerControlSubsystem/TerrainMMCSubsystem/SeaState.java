package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Tiles.SeaTile;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class SeaState implements TerrainMMCSubState{
    private static SeaState instance = new SeaState();
    public static SeaState getInstance(){return instance;}
    private SeaState(){}

    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToRock();
        }
        subContext.setSubState(RockState.getInstance());
    }
    public void right(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers){
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateTerrainToWoods();
        }
        subContext.setSubState(WoodsState.getInstance());
    }
    public void select(MapMakerControl context){

        //allocating current tile as SeaTile and placing it
        TileEditor.getInstance().createSeaTile();

        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        TileEditor.getInstance().commit(mmcObservers);


        //go back to Terrain selecting state of the controller
        context.setMmcState(TerrainMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "sea";
    }
}
