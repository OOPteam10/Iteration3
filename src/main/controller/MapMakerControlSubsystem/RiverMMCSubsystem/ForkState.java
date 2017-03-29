package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public class ForkState implements RiverMMCSubState {

    private static ForkState instance = new ForkState();
    public static ForkState getInstance(){return instance;}
    private ForkState(){
    }

    public void left(RiverMMCState subContext,Vector<MMCObserver> mmcObservers){

        subContext.setSubState(SourceState.getInstance());
    }
    public void right(RiverMMCState subContext,Vector<MMCObserver> mmcObservers){

        subContext.setSubState(NoRiverState.getInstance());
    }
    public void select(MapMakerControl context){
        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).riverSelected();
        }

        context.setMmcState(OrientationMMCState.getInstance(
                new ForkedRiver(HexSide.N, HexSide.SE.SE, HexSide.SW)));
    }

    //for testing
    public String toString(){
        return "fork";
    }

}
