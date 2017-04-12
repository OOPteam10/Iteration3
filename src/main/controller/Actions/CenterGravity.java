package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 12/04/17.
 */
public class CenterGravity extends Action {
    public CenterGravity(ControlHandler controlHandler){
        super(controlHandler);
    }
    @Override
    public void perform() {
        getControlHandler().centerGravity();
    }
}
