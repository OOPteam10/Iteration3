package controller.MapMakerControlSubsystem.RiverMMCSubsystem;

import controller.MapMakerControl;
import controller.MapMakerControlSubsystem.RiverMMCState;
import model.TileSubsystem.Rivers.River;

/**
 * Created by hankerins on 3/26/17.
 */
public interface RiverMMCSubState {
    public void left(RiverMMCState subContext);
    public void right(RiverMMCState subContext);
    public void select(MapMakerControl context);
}
