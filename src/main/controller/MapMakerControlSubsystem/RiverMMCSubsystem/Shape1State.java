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
public class Shape1State implements RiverMMCSubState {

    private static Shape1State instance = new Shape1State();
    public static Shape1State getInstance(){return instance;}

    public void left(RiverMMCState subContext){

        subContext.setSubState(NoRiverState.getInstance());
    }
    public void right(RiverMMCState subContext){

        subContext.setSubState(Shape2State.getInstance());
    }
    public void select(MapMakerControl context){
        context.setMmcState(OrientationMMCState.getInstance(
                new NormalRiver(CardinalDirection.NNE, CardinalDirection.ENE)));
    }
    //for testing
    public String toString(){
        return "shape 1";
    }

}
