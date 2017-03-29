package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.DesertState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.TerrainMMCSubState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;
import utilities.TileEditor;

/**
 * Created by rishabh on 26/03/17.
 */
public class OrientationMMCState implements MMCState {

    int offset;
    River currentRiver;


    private static OrientationMMCState instance = new OrientationMMCState();
    public static OrientationMMCState getInstance(River river){
        instance.currentRiver = river;
        return instance;
    }
    private OrientationMMCState(){
        offset = 0;
    }

    public void left(){
        currentRiver.rotateL();
    }
    public void right(){
        currentRiver.rotateR();
    }
    public void select(MapMakerControl context){
        //context.setTile(new RiverTile(context.getCurrentTerrain(), currentRiver));
        //context.addTileToMap();
        TileEditor.getInstance().createRiverTile(currentRiver);

        //TODO handling code for commit not working
        TileEditor.getInstance().commit();
        context.setMmcState(TerrainMMCState.getInstance());
    }

    public void reset(MapMakerControl context){
        context.setMmcState(TerrainMMCState.getInstance());
    }

    //For testing
    public void printSubState(){
        System.out.println("offset " + offset + "\n");
    };
    //for testing
    public String toString(){
        return "orientation";
    }
}
