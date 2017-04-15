package controller.Actions;

import controller.Action;
import controller.ControlHandler;
import view.Camera;

/**
 * Created by rishabh on 14/04/17.
 */
public class CameraMoveDown extends CameraAction {

    public CameraMoveDown(ControlHandler controlHandler,Camera camera){
        super(controlHandler,camera);
    }
    @Override
    public void perform() {
        getControlHandler().moveMapDown(getCamera());
    }
}
