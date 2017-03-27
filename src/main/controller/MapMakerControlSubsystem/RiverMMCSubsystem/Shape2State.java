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
public class Shape2State implements RiverMMCSubState {

    private static Shape2State instance = new Shape2State();
    public static Shape2State getInstance(){return instance;}

    public void left(RiverMMCState subContext){

        subContext.setSubState(Shape1State.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(Shape3State.getInstance());
    }
    public void select(MapMakerControl context){
            context.setMmcState(OrientationMMCState.getInstance(
                    new NormalRiver(CardinalDirection.NNE, CardinalDirection.SE)));
        }

}
