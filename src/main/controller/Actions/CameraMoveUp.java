package controller.Actions;

import controller.Action;
import controller.ControlHandler;
import view.Camera;

/**
 * Created by rishabh on 14/04/17.
 */
public class CameraMoveUp extends CameraAction {

    public CameraMoveUp(ControlHandler controlHandler, Camera camera){
        super(controlHandler,camera);
    }
    @Override
    public void perform() {
        getControlHandler().moveMapUp(getCamera());
    }
}
