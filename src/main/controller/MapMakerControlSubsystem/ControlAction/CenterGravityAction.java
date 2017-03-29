package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

/**
 * Created by Kevin on 3/29/17.
 */

public class CenterGravityAction extends ControlAction{

    @Override
    public void execute(Controller controller) {

        controller.centerGravity();
    }
}
