package controller.MapMakerControlSubsystem;

import controller.MapMakerControl;

/**
 * Created by rishabh on 26/03/17.
 */
public interface MMCState {
    public void left();
    public void right();
    public void select(MapMakerControl context);

}
