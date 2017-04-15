package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public interface MMCState {
    void left(Vector<MMCObserver> mmcObservers);
    void right(Vector<MMCObserver> mmcObservers);
    void select(MapMakerControl context);

    //For testing
    void printSubState();
    String toString();
    void reset(MapMakerControl context);


}
