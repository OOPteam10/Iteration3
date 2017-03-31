package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

public class MoveCameraDownAction extends ControlAction{
    @Override
    public void execute(Controller controller){
        controller.moveMapDown();
    }
}
