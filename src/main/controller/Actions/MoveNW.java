package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 11/04/17.
 */
public class MoveNW extends Action {

    public MoveNW(ControlHandler controlHandler){
        super(controlHandler);
    }

    @Override
    public void perform() {
        getControlHandler().moveNW();
    }
}
