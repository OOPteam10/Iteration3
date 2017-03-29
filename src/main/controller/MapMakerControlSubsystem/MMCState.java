package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public interface MMCState {
    public void left(Vector<MMCObserver> mmcObservers);
    public void right(Vector<MMCObserver> mmcObservers);
    public void select(MapMakerControl context);

    //For testing
    public void printSubState();
    public String toString();
    public void reset(MapMakerControl context);


}
