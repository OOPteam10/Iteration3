package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

public class MoveCameraUpAction extends ControlAction{
    @Override
    public void execute(Controller controller){
        controller.moveMapUp();
    }
}
