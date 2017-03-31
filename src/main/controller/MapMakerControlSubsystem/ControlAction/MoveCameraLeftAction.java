package controller.MapMakerControlSubsystem.ControlAction;

import controller.Controller;

public class MoveCameraLeftAction extends ControlAction{
    @Override
    public void execute(Controller controller){
        controller.moveMapLeft();
    }
}
