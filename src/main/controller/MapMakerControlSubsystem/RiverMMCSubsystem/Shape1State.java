package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.NormalRiver;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public class Shape1State implements RiverMMCSubState {

    private static Shape1State instance = new Shape1State();
    public static Shape1State getInstance(){return instance;}

    public void left(RiverMMCState subContext,Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToNone();
        }
        subContext.setSubState(NoRiverState.getInstance());
    }
    public void right(RiverMMCState subContext,Vector<MMCObserver> mmcObservers){

        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateRiverToShape2();
        }
        subContext.setSubState(Shape2State.getInstance());
    }
    public void select(MapMakerControl context){
        //notifying observers
        Vector<MMCObserver> mmcObservers = context.getMmcObservers();
        for(int i = 0;i<mmcObservers.size();i++){
            mmcObservers.get(i).riverSelected();
        }

        context.setMmcState(OrientationMMCState.getInstance(
                new NormalRiver(HexSide.N, HexSide.NE)));
    }
    //for testing
    public String toString(){
        return "shape 1";
    }

}
