package controller.MapMakerControlSubsystem.OrientationMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;

/**
 * Created by hankerins on 3/26/17.
 * THIS IS UNUSED RIGHT NOW, PROBABLY DOESN'T NEED TO BE USED
 */
public interface OrientationMMCSubState {
    public void left(OrientationMMCState subContext);
    public void right(OrientationMMCState subContext);
    public void select(MapMakerControl context);
}
