package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

public class MoveCameraRightAction extends ControlAction{
    @Override
    public void execute(Controller controller){
        controller.moveMapRight();
    }
}
