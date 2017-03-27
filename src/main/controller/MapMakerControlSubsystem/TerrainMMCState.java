package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.DesertState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.TerrainMMCSubState;

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

    public void left(){
        terrainMMCSubState.left(this);
    }
    public void right(){
        terrainMMCSubState.right(this);
    }
    public void select(MapMakerControl context){
        terrainMMCSubState.select(context);
        terrainMMCSubState = DesertState.getInstance();
    }
}
