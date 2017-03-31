package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

/**
 * Created by Shen on 3/29/17.
 */

public class ZoomOutAction extends ControlAction{

    @Override
    public void execute(Controller controller) {

        controller.cameraZoomOut();
    }
}
