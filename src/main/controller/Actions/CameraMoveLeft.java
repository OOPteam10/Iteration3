package controller.Actions;

import controller.ControlHandler;
import view.Camera;

/**
 * Created by rishabh on 14/04/17.
 */
public class CameraMoveLeft extends CameraAction {
    public CameraMoveLeft(ControlHandler controlHandler, Camera camera){
        super(controlHandler,camera);
    }
    @Override
    public void perform() {
        getControlHandler().moveMapLeft(getCamera());
    }
}
