package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.RiverMMCState;

import java.util.Vector;

/**
 * Created by hankerins on 3/26/17.
 */
public interface RiverMMCSubState {
    void left(RiverMMCState subContext, Vector<MMCObserver> mmcObservers);
    void right(RiverMMCState subContext, Vector<MMCObserver> mmcObservers);
    void select(MapMakerControl context);
}
