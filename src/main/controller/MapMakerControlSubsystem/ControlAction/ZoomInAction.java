package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

/**
 * Created by Shen on 3/29/17.
 */
public class ZoomInAction extends ControlAction{

    @Override
    public void execute(Controller controller) {

        controller.cameraZoomIn();
    }
}
