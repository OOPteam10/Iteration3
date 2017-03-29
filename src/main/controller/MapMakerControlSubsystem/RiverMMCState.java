package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCSubsystem.RiverMMCSubState;
import controller.MapMakerControlSubsystem.RiverMMCSubsystem.Shape1State;
import model.TileSubsystem.Rivers.River;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class RiverMMCState implements MMCState {
    RiverMMCSubState riverMMCSubState;

    public RiverMMCSubState getRiverMMCSubState() {
        return riverMMCSubState;
    }

    private static RiverMMCState instance = new RiverMMCState();
    public static RiverMMCState getInstance(){return instance;}
    private RiverMMCState(){
        riverMMCSubState = Shape1State.getInstance();
    }
    public void setSubState(RiverMMCSubState terrainMMCSubState){
        this.riverMMCSubState = terrainMMCSubState;
    }

    public void left(Vector<MMCObserver> mmcObservers){
        riverMMCSubState.left(this,mmcObservers);
    }
    public void right(Vector<MMCObserver> mmcObservers){
        riverMMCSubState.right(this,mmcObservers);
    }
    public void select(MapMakerControl context){
        riverMMCSubState.select(context);
        riverMMCSubState = Shape1State.getInstance();
    }

    public void reset(MapMakerControl context){
        context.setMmcState(TerrainMMCState.getInstance());
    }

    //For testing
    public void printSubState(){
        System.out.println("River " + riverMMCSubState.toString() + "\n");
    }
    //for testing
    public String toString(){
        return "river state";
    }
}
