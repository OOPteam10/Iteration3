package controller.Actions;

import controller.Action;
import controller.ControlHandler;
import view.Camera;

/**
 * Created by rishabh on 14/04/17.
 */
public abstract class CameraAction extends Action {

    private Camera camera;

    public CameraAction(ControlHandler controlHandler, Camera camera){
        super(controlHandler);
        this.camera = camera;
    }
    public Camera getCamera(){
        return camera;
    }

}
