package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Tiles.RiverTile;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public class Shape3State implements RiverMMCSubState {

    private static Shape3State instance = new Shape3State();
    public static Shape3State getInstance(){return instance;}

    public void left(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToShape2();
        }
        subContext.setSubState(Shape2State.getInstance());
    }
    public void right(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToSource();
        }
        subContext.setSubState(SourceState.getInstance());
    }
    public void select(MapMakerControl context){
        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).riverSelected();
        }

        context.setMmcState(OrientationMMCState.getInstance(
                new NormalRiver(HexSide.N, HexSide.S)));
    }
    //for testing
    public String toString(){
        return "shape 3";
    }

}
