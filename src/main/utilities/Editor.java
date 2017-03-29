package utilities;

import controller.MapMakerControlSubsystem.MMCObserver;

import java.util.Vector;

/**
 * Created by cduica on 3/27/17.
 */
public interface Editor {

    boolean commit(Vector<MMCObserver> mmcObserverVector);
    //void discard();

}
