package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 07/04/17.
 */
public class MoveNorth extends Action {

    public MoveNorth(ControlHandler controlHandler){
        super(controlHandler);
    }

    @Override
    public void perform() {
        getControlHandler().moveN();
    }
}
