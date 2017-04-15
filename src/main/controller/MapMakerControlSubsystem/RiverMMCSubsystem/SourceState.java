package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.SourceRiver;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public class SourceState implements RiverMMCSubState {

    private static SourceState instance = new SourceState();
    public static SourceState getInstance(){return instance;}
    private SourceState(){}

    public void left(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToShape3();
        }
        subContext.setSubState(Shape3State.getInstance());
    }
    public void right(RiverMMCState subContext, Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToFork();
        }

        subContext.setSubState(ForkState.getInstance());
    }
    public void select(MapMakerControl context){
        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).riverSelected();
        }

        context.setMmcState(OrientationMMCState.getInstance(
                new SourceRiver(HexSide.N)));
    }
    //for testing
    public String toString(){
        return "source";
    }

}
