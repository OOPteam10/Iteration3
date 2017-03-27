package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;

/**
 * Created by hankerins on 3/27/17.
 */
public class NoRiverState implements RiverMMCSubState {
    private static NoRiverState instance = new NoRiverState();
    public static NoRiverState getInstance(){return instance;}
    private NoRiverState(){
    }

    public void left(RiverMMCState subContext){

        subContext.setSubState(ForkState.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(Shape1State.getInstance());
    }
    public void select(MapMakerControl context){
        context.setTile(new LandTile(context.getCurrentTerrain()));
        context.addTileToMap();
        context.setMmcState(TerrainMMCState.getInstance());
    }
    //for testing
    public String toString(){
        return "no river";
    }

}
