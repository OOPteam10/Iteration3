package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public interface TerrainMMCSubState {
    public void left(TerrainMMCState subContext,Vector<MMCObserver> mmcObservers);
    public void right(TerrainMMCState subContext, Vector<MMCObserver> mmcObservers);
    public void select(MapMakerControl context);

}
