package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 07/04/17.
 */
public class NextMode extends Action {
    public NextMode(ControlHandler controlHandler){
        super(controlHandler);
    }

    @Override
    public void perform() {
        getControlHandler().nextMode();
    }
}
