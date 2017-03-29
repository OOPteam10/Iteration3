package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.Rivers.River;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public interface RiverMMCSubState {
    public void left(RiverMMCState subContext,Vector<MMCObserver> mmcObservers);
    public void right(RiverMMCState subContext, Vector<MMCObserver> mmcObservers);
    public void select(MapMakerControl context);
}
