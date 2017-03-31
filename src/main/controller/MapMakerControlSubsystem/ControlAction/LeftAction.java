package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

/**
 * Created by Kevin on 3/29/17.
 */

public class LeftAction extends ControlAction{

    @Override
    public void execute(Controller controller) {
        controller.left();
    }
}
