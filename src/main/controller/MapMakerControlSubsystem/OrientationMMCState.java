package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCSubsystem.OrientationMMCSubState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.DesertState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.TerrainMMCSubState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;

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
        offset--;
        offset += 6;
        offset %= 6;
    }
    public void right(){
        offset++;
        offset %= 6;
    }
    public void select(MapMakerControl context){
        currentRiver.rotate(offset);
        context.setTile(new RiverTile(context.getCurrentTerrain(), currentRiver));
        context.addTileToMap();
        context.setMmcState(TerrainMMCState.getInstance());
    }
}
