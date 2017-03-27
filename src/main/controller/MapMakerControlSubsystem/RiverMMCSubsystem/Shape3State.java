package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;

/**
 * Created by hankerins on 3/26/17.
 */
public class Shape3State implements RiverMMCSubState {

    private static Shape3State instance = new Shape3State();
    public static Shape3State getInstance(){return instance;}

    public void left(RiverMMCState subContext){

        subContext.setSubState(Shape2State.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(SourceState.getInstance());
    }
    public void select(MapMakerControl context){
        context.setMmcState(OrientationMMCState.getInstance(
                new NormalRiver(CardinalDirection.NNE, CardinalDirection.SSW)));
    }

}
