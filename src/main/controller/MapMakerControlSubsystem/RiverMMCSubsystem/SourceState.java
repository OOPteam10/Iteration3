package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Tiles.RiverTile;

/**
 * Created by hankerins on 3/26/17.
 */
public class SourceState implements RiverMMCSubState {

    private static SourceState instance = new SourceState();
    public static SourceState getInstance(){return instance;}
    private SourceState(){}

    public void left(RiverMMCState subContext){

        subContext.setSubState(Shape3State.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(ForkState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setMmcState(OrientationMMCState.getInstance(
                new SourceRiver(HexSide.N)));
    }
    //for testing
    public String toString(){
        return "source";
    }

}
