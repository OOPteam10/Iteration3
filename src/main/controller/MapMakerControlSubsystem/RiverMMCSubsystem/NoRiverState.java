package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import utilities.TileEditor;

import java.util.Vector;

/**
 * Created by hankerins on 3/27/17.
 */
public class NoRiverState implements RiverMMCSubState {
    private static NoRiverState instance = new NoRiverState();
    public static NoRiverState getInstance(){return instance;}
    private NoRiverState(){
    }

    public void left(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToFork();
        }
        subContext.setSubState(ForkState.getInstance());
    }
    public void right(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToShape1();
        }
        subContext.setSubState(Shape1State.getInstance());
    }
    public void select(MapMakerControl context){
        //context.setTile(new LandTile(context.getCurrentTerrain()));
        //context.addTileToMap();

        //create and commit a this current Tile as  LandTile
        TileEditor.getInstance().createLandTile();
        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        TileEditor.getInstance().commit(mmcObservers);


        // make next transition of state machine
        context.setMmcState(TerrainMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "no river";
    }

}
