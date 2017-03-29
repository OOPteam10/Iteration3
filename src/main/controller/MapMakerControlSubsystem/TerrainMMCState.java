package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.DesertState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.TerrainMMCSubState;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class TerrainMMCState implements MMCState {

    TerrainMMCSubState terrainMMCSubState;

    private static TerrainMMCState instance = new TerrainMMCState();
    public static TerrainMMCState getInstance(){return instance;}
    private TerrainMMCState(){
        terrainMMCSubState = DesertState.getInstance();
    }

    public void setSubState(TerrainMMCSubState terrainMMCSubState){
        this.terrainMMCSubState = terrainMMCSubState;
    }

    public void left(Vector<MMCObserver> mmcObservers){
        terrainMMCSubState.left(this,mmcObservers);
    }
    public void right(Vector<MMCObserver> mmcObservers){
        terrainMMCSubState.right(this,mmcObservers);
    }
    public void select(MapMakerControl context){
        terrainMMCSubState.select(context);
        terrainMMCSubState = DesertState.getInstance();
    }

    public void reset(MapMakerControl context){
        terrainMMCSubState = DesertState.getInstance();
    }

    //For testing
    public void printSubState(){
        System.out.println("Terrain " + terrainMMCSubState.toString() + "\n");
    }
    //for testing
    public String toString(){
        return "terrain";
    }
}
