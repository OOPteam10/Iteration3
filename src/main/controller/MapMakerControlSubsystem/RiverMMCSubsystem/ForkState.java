package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkState implements RiverMMCSubState {

    private static ForkState instance = new ForkState();
    public static ForkState getInstance(){return instance;}
    private ForkState(){
    }

    public void left(RiverMMCState subContext){

        subContext.setSubState(SourceState.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(NoRiverState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setMmcState(OrientationMMCState.getInstance(
                new ForkedRiver(CardinalDirection.NNE, CardinalDirection.SE, CardinalDirection.WSW)));
    }

    //for testing
    public String toString(){
        return "fork";
    }

}
