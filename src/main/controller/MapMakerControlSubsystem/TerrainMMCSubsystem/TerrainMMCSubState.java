package controller.MapMakerControlSubsystem.TerrainMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.OrientationMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;

/**
 * Created by rishabh on 26/03/17.
 */
public interface TerrainMMCSubState {
    public void left(TerrainMMCState subContext);
    public void right(TerrainMMCState subContext);
    public void select(MapMakerControl context);

}
